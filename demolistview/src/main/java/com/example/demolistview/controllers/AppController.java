package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class AppController {
    @FXML
    private ListView listView; //
    @FXML
    private Label lblMsg;
    @FXML
    private final ObservableList data = FXCollections.observableArrayList();

    private PersonService service= new PersonService();
}
