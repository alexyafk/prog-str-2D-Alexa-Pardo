module com.example.contactosemergencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactosemergencia to javafx.fxml;
    exports com.example.contactosemergencia;
}