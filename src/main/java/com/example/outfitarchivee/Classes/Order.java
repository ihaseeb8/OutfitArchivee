package com.example.outfitarchivee.Classes;

public class Order {
    int id;
    String phoneNo;
    double bill;
    String status;


    public Order() {
        id = 0;
        phoneNo = "";
        bill = 0;
        status = "";
    }

    public Order(int id, String phoneNo, double bill, String status) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.bill = bill;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
