package com.example.renterproject2.models;

import java.util.Date;

public class Cars {
    private int id ;
    private String model;
    private Date year;
    private String gos_num;
    private String mark;
    private  String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getGos_num() {
        return gos_num;
    }

    public void setGos_num(String gos_num) {
        this.gos_num = gos_num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Id :"+id+"\t\tModel : "+model+"\t\tYear : "+year+"\t\tGos_Num : "+gos_num+"\t\tMark : "+mark+"\t\tType : "+type;

    }
}
