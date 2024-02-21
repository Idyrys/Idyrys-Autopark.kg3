package com.example.renterproject2.services.impl;

import com.example.renterproject2.models.Renter;
import com.example.renterproject2.repository.RenterRepo;
import com.example.renterproject2.services.RenterServices;
import javafx.scene.control.Alert;
import org.w3c.dom.ls.LSOutput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RenterServicesImpl implements RenterServices {
    RenterRepo renterRepo = new RenterRepo();
    @Override
    public boolean createRenter(Renter renter) {
        return false;
    }

    @Override
    public void sevRenter(String firstName, String lastName, String inn,String phoneNumber, String category) {


        try {
            Statement statement = renterRepo.connectToDataBase().createStatement();
                statement.executeUpdate("insert into tb_renter (first_name, last_name, inn, phone_num, drive_category) values ('"+firstName+"', '"+lastName+"', '"+inn+"', '"+phoneNumber+"', '"+category+"')");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Успешно зарегистрирована!");
            alert.show();

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка !");
            alert.show();
            System.out.println("Ошибка :"+e.getMessage());

        }
    }

    @Override
    public ArrayList<Renter> getAllUsers() {
        try {
            PreparedStatement preparedStatement = renterRepo.connectToDataBase().prepareStatement("select * from tb_renter");
            ArrayList<Renter> allUsers = new ArrayList<>();
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()){
                Renter renter= new Renter();
                renter.setId(res.getInt("id"));
                renter.setFirst_name(res.getString("first_name"));
                renter.setLast_name(res.getString("last_name"));
                renter.setInn(res.getString("inn"));
                renter.setPhone_num(res.getString("phone_num"));
                renter.setDrive_category(res.getString("drive_category"));
                allUsers.add(renter);
            } return allUsers;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private final List<Renter> products = new ArrayList<>();

}
