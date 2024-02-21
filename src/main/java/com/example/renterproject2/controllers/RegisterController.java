package com.example.renterproject2.controllers;

import java.net.URL;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.renterproject2.models.Cars;
import com.example.renterproject2.models.Renter;
import com.example.renterproject2.services.CarServices;
import com.example.renterproject2.services.RenterServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController {

   private  final RenterServices renterServices = RenterServices.INSTANCE;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtInn;

    @FXML
    private TextField txtLastName ;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtRight;

    @FXML
    void onSaveClicked(ActionEvent event) {
        String inn = txtInn.getText();
        ArrayList<Renter> allUsers = renterServices.getAllUsers();
        for (Renter allUser : allUsers) {
            if (allUser.getInn().equals(inn)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Пользователь с таким inn уже существует !");
                alert.show();
                return;
            }
        }

        Renter renter = new Renter();
        if (!txtFirstName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtInn.getText().isEmpty() && !txtPhoneNumber.getText().isEmpty() && !txtRight.getText().isEmpty()){
            renter.setFirst_name(txtFirstName.getText());
            renter.setLast_name(txtLastName.getText());
            renter.setInn(txtInn.getText());
            renter.setPhone_num(txtPhoneNumber.getText());
            renter.setDrive_category(txtRight.getText());

            renterServices.sevRenter(renter.getFirst_name(), renter.getLast_name(), renter.getInn(), renter.getPhone_num(), renter.getDrive_category());

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка !");
            alert.show();

        }

    }

    @FXML
    void initialize() {

    }

}
