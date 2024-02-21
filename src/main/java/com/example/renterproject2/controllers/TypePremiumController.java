package com.example.renterproject2.controllers;

import com.example.renterproject2.models.Cars;
import com.example.renterproject2.services.CarServices;
import com.example.renterproject2.services.RenterServices;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.util.ArrayList;

public class TypePremiumController {

    private final CarServices carServices = CarServices.INSTANCE;

    @FXML
    private Button buttonBook;

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

        carServices.addToRentInfoP(inn, carId, endDate);

    }


    @FXML
    private ListView<Cars> listViewPremium;

    @FXML
    void initialize() {
        ArrayList<Cars> premiumCars = carServices.getAllPremiumCars();
        listViewPremium.setItems(FXCollections.observableList(premiumCars));
    }

}
