package com.example.demo1.controlers;

import com.example.demo1.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
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
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service= new PersonService();

    @FXML
    public void initialize() { //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView

        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
        loadDataForm(newValue);
        });

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
        String name= textnombre.getText();
        String email= textemail.getText();
        String edad= textedad.getText();
        try {
            service.updatePerson(index,name,email,edad);
            lblMsg.setText("Actualizacion correcta");
            lblMsg.setStyle("-fx-text-fill: green");
            textnombre.clear();
            textemail.clear();
            textedad.clear();
            loadFromFile();
        }catch (IOException e ){
            lblMsg.setText("Hubo un error ");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
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
    private void loadDataForm(String item){
        String[] parts = item.split("-");
        textnombre.setText(parts[0]);
        textemail.setText(parts[1]);
        textedad.setText(parts[2]);
    }

}