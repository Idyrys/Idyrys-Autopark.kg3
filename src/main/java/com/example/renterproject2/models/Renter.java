package com.example.renterproject2.models;

public class Renter {
    private int id;
    private String first_name;
    private String last_name;
    private String inn;
    private String phone_num;
    private String drive_category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getDrive_category() {
        return drive_category;
    }

    public void setDrive_category(String drive_category) {
        this.drive_category = drive_category;
    }
}
