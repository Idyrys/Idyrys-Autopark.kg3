package com.example.renterproject2.services.impl;

import com.example.renterproject2.models.Cars;
import com.example.renterproject2.models.Renter;
import com.example.renterproject2.repository.RenterRepo;
import com.example.renterproject2.services.CarServices;
import com.example.renterproject2.services.RenterServices;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class CarServicesImpl implements CarServices {

    RenterServices renterServices = RenterServices.INSTANCE;
    RenterRepo renterRepo = new RenterRepo();


    @Override
    public void addToRentInfoP(String inn, int carId, String inputDate) {

        try {
            Date newStartDate = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            ArrayList<Renter> allUsers = renterServices.getAllUsers();
            ArrayList<Cars> allCars1 = getAllPremiumCars();
            for (Renter allUser : allUsers) {
                if (allUser.getInn().equals(inn)) {
                    int renterId = allUser.getId();
                    Date newEndDate = format.parse(inputDate);

                    for (Cars cars : allCars1) {

                        if (cars.getId() == carId) {
                            Statement statement = renterRepo.connectToDataBase().createStatement();
                            statement.executeUpdate("insert into tb_rent_info ( start_date, end_date, renter_id, car_id, status) values ('" + newStartDate + "', '" + newEndDate + "', '" + renterId + "', '" + carId + "', 'in_progerss')");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Успешно забронировано !");
                            alert.show();
                            return;
                        }
                    }


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка !");
                    alert.show();
                    return;
                }
            }

        } catch (java.text.ParseException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка! Некорректный формат даты.");
            alert.show();
            System.out.println("Ошибка! Некорректный формат даты.");

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Машина id = " + carId + " занят !");
            alert.show();
            System.out.println("Ошибка :" + e.getMessage());
        }
    }

    @Override
    public void addToRentInfoE(String inn, int carId, String inputDate) {

        try {
            Date newStartDate = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            ArrayList<Renter> allUsers = renterServices.getAllUsers();
            ArrayList<Cars> allCars1 = getAllEconomyCars();
            for (Renter allUser : allUsers) {
                if (allUser.getInn().equals(inn)) {
                    int renterId = allUser.getId();
                    Date newEndDate = format.parse(inputDate);

                    for (Cars cars : allCars1) {

                        if (cars.getId() == carId) {
                            Statement statement = renterRepo.connectToDataBase().createStatement();
                            statement.executeUpdate("insert into tb_rent_info ( start_date, end_date, renter_id, car_id, status) values ('" + newStartDate + "', '" + newEndDate + "', '" + renterId + "', '" + carId + "', 'in_progerss')");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Успешно забронировано !");
                            alert.show();
                            return;
                        }
                    }


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка !");
                    alert.show();
                    return;
                }
            }

        } catch (java.text.ParseException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка! Некорректный формат даты.");
            alert.show();
            System.out.println("Ошибка! Некорректный формат даты.");

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Машина id = " + carId + " занят !");
            alert.show();
            System.out.println("Ошибка :" + e.getMessage());
        }
    }

    @Override
    public void addToRentInfoL(String inn, int carId, String inputDate) {

        try {
            Date newStartDate = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            ArrayList<Renter> allUsers = renterServices.getAllUsers();
            ArrayList<Cars> allCars1 = getAllLuxCars();
            for (Renter allUser : allUsers) {
                if (allUser.getInn().equals(inn)) {
                    int renterId = allUser.getId();
                    Date newEndDate = format.parse(inputDate);

                    for (Cars cars : allCars1) {

                        if (cars.getId() == carId) {
                            Statement statement = renterRepo.connectToDataBase().createStatement();
                            statement.executeUpdate("insert into tb_rent_info ( start_date, end_date, renter_id, car_id, status) values ('" + newStartDate + "', '" + newEndDate + "', '" + renterId + "', '" + carId + "', 'in_progerss')");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Успешно забронировано !");
                            alert.show();
                            return;
                        }else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Машин  с id = "+carId+" не существует !");
                            alert.show();
                            return;
                        }
                    }


                }
            }

        } catch (java.text.ParseException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ошибка! Некорректный формат даты.");
            alert.show();
            System.out.println("Ошибка! Некорректный формат даты.");

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Машина id = " + carId + " занят !");
            alert.show();
            System.out.println("Ошибка :" + e.getMessage());
        }
    }

    public ArrayList<Cars> getAllPremiumCars() {
        try {
            PreparedStatement preparedStatement = renterRepo.connectToDataBase().prepareStatement("select * from tb_cars  where type_e = 'premium'");
            ArrayList<Cars> allCars = new ArrayList<>();
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Cars cars = new Cars();
                cars.setId(res.getInt("id"));
                cars.setModel(res.getString("model_t"));
                cars.setYear(res.getDate("year_d"));
                cars.setGos_num(res.getString("gos_num"));
                cars.setMark(res.getString("mark"));
                cars.setType(res.getString("type_e"));
                allCars.add(cars);
            }

            return allCars;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Cars> getAllLuxCars() {
        try {
            PreparedStatement preparedStatement = renterRepo.connectToDataBase().prepareStatement("select * from tb_cars  where type_e = 'lux'");
            ArrayList<Cars> allCars = new ArrayList<>();
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Cars cars = new Cars();
                cars.setId(res.getInt("id"));
                cars.setModel(res.getString("model_t"));
                cars.setYear(res.getDate("year_d"));
                cars.setGos_num(res.getString("gos_num"));
                cars.setMark(res.getString("mark"));
                cars.setType(res.getString("type_e"));
                allCars.add(cars);
            }

            return allCars;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Cars> getAllEconomyCars() {
        try {
            PreparedStatement preparedStatement = renterRepo.connectToDataBase().prepareStatement("select * from tb_cars  where type_e = 'econom'");
            ArrayList<Cars> allCars = new ArrayList<>();
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Cars cars = new Cars();
                cars.setId(res.getInt("id"));
                cars.setModel(res.getString("model_t"));
                cars.setYear(res.getDate("year_d"));
                cars.setGos_num(res.getString("gos_num"));
                cars.setMark(res.getString("mark"));
                cars.setType(res.getString("type_e"));
                allCars.add(cars);
            }

            return allCars;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
