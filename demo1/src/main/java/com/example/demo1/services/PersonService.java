package com.example.demo1.services;

import com.example.demo1.repositories.personFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private personFileRepository repo = new personFileRepository();

    public List<String>LoaddataForList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;
            String [] parts = line.split(",", -1);
            String name= parts[0].trim();
            String correo=parts[1].trim();
            String edad=parts[2].trim();
            result.add(name+"-"+correo+"-"+edad);
        }
        return result;
    }

    public void addPerson(String nombre, String email, String edad) throws IOException {
        validatePerson(nombre,email, edad);
        String nameNoComan = nombre.replace(",", "");
        String emailNoComan = email.replace(",", "");
        String edadNoComan = edad.replace(",","");

        repo.appendNewLine(nameNoComan+","+emailNoComan+","+edadNoComan);
    }
    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        List<String> lines = getAllCleanLines();
        if (index == -1){
            throw new  IllegalArgumentException("El indice recibido es invalido");
        }
        lines.set(index, name+","+email+","+edad);
        repo.appendAllLines(lines);
    }
    public void deletePerson(int index) throws IOException{
        List<String> lines = getAllCleanLines();
        lines.remove(index);
        repo.appendAllLines(lines);

    }
    private List<String> getAllCleanLines() throws IOException{
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : lines){
            if(line!=null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }
    private void validatePerson(String nombre, String email, String edad){
        if (nombre.isEmpty() || nombre.length()<3 ) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isEmpty() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
        if (!edad.isEmpty()){
            try {
                int e = Integer.parseInt(edad);
                if(e<18){
                    throw new IllegalArgumentException("No puede ser menor de edad");
                }
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("La edad no es un entero");
            }

        }else{
            throw new IllegalArgumentException("Edad no puede ir vacia");
        }
    }

}
