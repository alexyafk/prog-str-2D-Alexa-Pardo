package com.example.demo1.controlers;

import com.example.demo1.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField textnombre;
    @FXML
    private TextField textemail;
    @FXML
    private TextField textedad;
    @FXML
    private TextField busqueda;


    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service= new PersonService();

    private void filtrarLista(String textoABuscar) {
        List<String> filtrada = new ArrayList<>();

      for(String busq : data){
          String [] partesDelString = busq.split("-");
          System.out.println(partesDelString[1]);
          if(partesDelString[1].contains(textoABuscar)){
              filtrada.add(busq);
          }
      }
      data.setAll(filtrada);

    }

    @FXML
    public void initialize(){

        loadFromFile();
        busqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.isEmpty()) {
                filtrarLista(newValue);
            }else{
                loadFromFile();
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener( (obs, oldValue, newValue)->{
            loadDataToForms(newValue);
                }

        );
        listView.setItems(data);


    }
    @FXML
    public void onAddPerson() throws IOException {
        try {


            String name = textnombre.getText();
            String email = textemail.getText();
            String edad = textedad.getText();
            service.addPerson(name,email,edad);
            lblMsg.setText("Persona agregada con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            textnombre.clear();
            textemail.clear();
            textedad.clear();
            loadFromFile();
        }catch (IOException e){
            lblMsg.setText("Hubo un error ");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }

    }
    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = textnombre.getText();
        String email = textemail.getText();
        String edad = textedad.getText();
        try{
            service.updatePerson(index,name,email,edad);
            loadFromFile();
            lblMsg.setText("Actualizacion correcta");
            lblMsg.setStyle("-fx-text-fill: green");
            textnombre.clear();
            textemail.clear();
            textedad.clear();
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (IllegalArgumentException e){

        }
    }

    @FXML
    private void onDelete(){
        int index = listView.getSelectionModel().getSelectedIndex();
        try{
            service.deletePerson(index);
            loadFromFile();
            lblMsg.setText("Persona eliminada correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            textnombre.clear();
            textemail.clear();
            textedad.clear();
        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo en eliminar");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    private void loadFromFile(){
        try{
            List<String> items = service.LoaddataForList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    private void loadDataToForms(String item){
        String[] parts = item.split("-");
        textnombre.setText(parts[0]);
        textemail.setText(parts[1]);
        textedad.setText(parts[2]);
    }
    @FXML
    private void onReload(){
        loadFromFile();

    }

}