package com.example.contactosemergencia;
import com.example.contactosemergencia.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class HelloController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> comboParentesco;
    @FXML private ListView<Contacto> listViewContactos;

    private ObservableList<Contacto> lista = FXCollections.observableArrayList();

    private String[] parentescos = {
            "Padre","Madre","Hermano","Hermana",
            "Abuelo","Abuela","Tío","Tía"
    };

    @FXML
    public void initialize() {
        comboParentesco.getItems().addAll(parentescos);
        listViewContactos.setItems(lista);
    }

    @FXML
    public void agregar() {
        String nombre = txtNombre.getText();
        String tel = txtTelefono.getText();
        String par = comboParentesco.getValue();

        if(nombre.isEmpty() || tel.isEmpty() || par == null){
            alerta("Llena todos los campos");
            return;
        }

        if(!tel.matches("\\d{10}")){
            alerta("Teléfono inválido");
            return;
        }

        for(Contacto c : lista){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                alerta("Ya existe");
                return;
            }
        }

        lista.add(new Contacto(nombre,tel,par));
        limpiar();
    }

    @FXML
    public void buscar() {
        String nombre = txtNombre.getText();

        for(Contacto c : lista){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                txtTelefono.setText(c.getTelefono());
                comboParentesco.setValue(c.getParentesco());
                return;
            }
        }

        alerta("No encontrado");
    }

    @FXML
    public void actualizar() {
        String nombre = txtNombre.getText();

        for(Contacto c : lista){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                c.setTelefono(txtTelefono.getText());
                c.setParentesco(comboParentesco.getValue());
                listViewContactos.refresh();
                return;
            }
        }
    }

    @FXML
    public void eliminar() {
        String nombre = txtNombre.getText();

        lista.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
        limpiar();
    }

    @FXML
    public void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        comboParentesco.setValue(null);
    }

    private void alerta(String msg){
        new Alert(Alert.AlertType.INFORMATION,msg).show();
    }
}