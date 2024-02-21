package com.example.renterproject2.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.renterproject2.models.Cars;
import com.example.renterproject2.services.CarServices;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TypeEconomyController {
    private final CarServices carServices = CarServices.INSTANCE;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBook;

    @FXML
    private ListView<Cars> listViewEconomy;

    @FXML
    private TextField textFieldEndDate;

    @FXML
    private TextField textFieldIdCar;

    @FXML
    private TextField textFieldInn;

    @FXML
    void onSearchButtonClicked(ActionEvent event) {
        if (textFieldInn.getText().isEmpty() || textFieldIdCar.getText().isEmpty() || textFieldEndDate.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка !");
            alert.show();
            return;
        }
        String inn = textFieldInn.getText();
        int carId = Integer.parseInt(textFieldIdCar.getText());
        String endDate = textFieldEndDate.getText();

        carServices.addToRentInfoE(inn, carId, endDate);
    }

    @FXML
    void initialize() {
        ArrayList<Cars> economyCars = carServices.getAllEconomyCars();
        listViewEconomy.setItems(FXCollections.observableList(economyCars));
    }

}
