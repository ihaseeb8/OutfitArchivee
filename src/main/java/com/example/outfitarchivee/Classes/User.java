package com.example.outfitarchivee.Classes;

public class User {

    private long phoneNo;
    private String name;
    private String email;
    private String address;
    private String password;

    private static User user = new User();

    private User(){
        name = null;
        email = null;
        address = null;
        password = null;
    }

    public static User getUser(){
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {this.address = address;}

    public String getAddress() {
        return address;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
