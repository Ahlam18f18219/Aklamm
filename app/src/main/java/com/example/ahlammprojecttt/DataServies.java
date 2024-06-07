package com.example.ahlammprojecttt;

public class DataServies {
    private String imageURL;
    private String name;
    private String price;
    private String Description;

    public DataServies(){

    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public DataServies(String imageURL, String name, String price, String Description) {
        this.imageURL = imageURL;
        this.name = name;
        this.price = price;
        this.Description = Description;
    }

}

