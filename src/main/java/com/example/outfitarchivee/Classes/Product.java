package com.example.outfitarchivee.Classes;

public class Product {

    String id;
    String gender;
    String name;
    String type;
    double price;
    String color;
    String size;
    String description;
    int quantity;

    public Product() {
        this.id = "";
        this.price = 0;
        this.quantity = 0;
        this.name = "";
        this.color = "";
        this.size = "";
        this.description = "";
        this.type = "";
        this.gender = "";
    }

    public Product(String id, double price, int quantity, String name, String color,String size,String description, String type,String gender) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.color = color;
        this.size = size;
        this.description = description;
        this.type = type;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

