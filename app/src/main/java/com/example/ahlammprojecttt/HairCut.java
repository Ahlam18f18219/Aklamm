package com.example.ahlammprojecttt;

public class HairCut {
    String name, phone, Date, servies;

    public String getServies() {
        return servies;
    }

    public void setServies(String servies) {
        this.servies = servies;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HairCut(String name, String phone, String Date, String servies) {
        this.name = name;
        this.phone = phone;
        this.Date = Date;
        this.servies = servies;
    }

    public HairCut() {
    }
}


