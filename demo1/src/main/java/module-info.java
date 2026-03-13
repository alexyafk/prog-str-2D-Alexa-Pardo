module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo1 to javafx.fxml;
    opens com.example.demo1.controlers to javafx.fxml;
    opens com.example.demo1.services to javafx.fxml;
    opens com.example.demo1.repositories to javafx.fxml;

    exports com.example.demo1;
    exports com.example.demo1.repositories;
    exports com.example.demo1.controlers;
    exports com.example.demo1.services;
}