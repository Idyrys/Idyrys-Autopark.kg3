package com.example.renterproject2.services;

import com.example.renterproject2.models.Renter;
import com.example.renterproject2.services.impl.RenterServicesImpl;

import java.util.ArrayList;
import java.util.List;

public interface RenterServices {
    RenterServicesImpl INSTANCE = new RenterServicesImpl();
    boolean createRenter(Renter renter);
    void sevRenter(String firstName, String lastName, String inn,String phoneNumber, String category);
    ArrayList<Renter> getAllUsers();

}
