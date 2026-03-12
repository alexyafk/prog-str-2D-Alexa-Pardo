package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {

        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines) {

            if (line == null || line.isBlank()) {
                continue;
            }

            String name = "";
            String correo = "";
            String texto = line;

            int posicion = 0;

            while (posicion < texto.length()) {

                if (texto.substring(posicion, posicion + 1).equals(",")) {
                    name = texto.substring(0, posicion).trim();
                    texto = texto.substring(posicion + 1);
                    break;
                }

                posicion++;
            }

            posicion = 0;

            while (posicion < texto.length()) {

                if (texto.substring(posicion, posicion + 1).equals(",")) {
                    correo = texto.substring(0, posicion).trim();
                    break;
                }

                posicion++;
            }

            result.add(name + "-" + correo);
        }

        return result;
    }

    public void addPerson(String nombre, String email, String edad) throws IOException {

        validatePerson(nombre, email, edad);

        String nameNoComan = nombre.replace(",", "");
        String emailNoComan = email.replace(",", "");
        String edadNoComan = edad.replace(",", "");

        repo.appendNewLine(nameNoComan + "," + emailNoComan + "," + edadNoComan);
    }

    private void validatePerson(String nombre, String email, String edad){

        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        } else {

            String nom = nombre.trim();

            if (nom.isEmpty()) {
                throw new IllegalArgumentException("El nombre no cumple con los estandares");
            } else {

                if (nom.length() < 3) {
                    throw new IllegalArgumentException("El nombre no cumple con los estandares");
                }
            }
        }

        if (email == null) {
            throw new IllegalArgumentException("El email no es valido");
        } else {

            String em = email.trim();

            if (em.isEmpty()) {
                throw new IllegalArgumentException("El email no es valido");
            } else {

                if (em.contains("@")) {

                    if (em.contains(".")) {

                    } else {
                        throw new IllegalArgumentException("El email no es valido");
                    }

                } else {
                    throw new IllegalArgumentException("El email no es valido");
                }
            }
        }

        if (edad == null) {
            throw new IllegalArgumentException("La edad debe ser numerica");
        } else if (edad.isBlank()) {
            throw new IllegalArgumentException("La edad debe ser numerica");
        } else {

            try {

                int numEdad = Integer.parseInt(edad.trim());

                if (numEdad >= 18) {

                } else {
                    throw new IllegalArgumentException("Solo se aceptan mayores de 18");
                }

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("La edad debe ser numerica");
            }
        }
    }
}