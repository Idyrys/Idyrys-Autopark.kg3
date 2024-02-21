package com.example.renterproject2.services;

import com.example.renterproject2.models.Cars;
import com.example.renterproject2.models.Renter;
import com.example.renterproject2.services.impl.CarServicesImpl;

import java.util.ArrayList;

public interface CarServices {
    CarServicesImpl INSTANCE = new CarServicesImpl();
    ArrayList<Cars> getAllLuxCars();
    ArrayList<Cars> getAllEconomyCars();
    ArrayList<Cars> getAllPremiumCars();

    void addToRentInfoP(String inn, int carId,String inputDate);
    void addToRentInfoE(String inn, int carId,String inputDate);
    void addToRentInfoL(String inn, int carId,String inputDate);

}
