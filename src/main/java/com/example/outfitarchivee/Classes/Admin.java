package com.example.outfitarchivee.Classes;

public class Admin {

    private long phoneNo;
    private String name;
    private String email;
    private String password;

    private static Admin admin = new Admin();

    private Admin(){
        name = null;
        email = null;
        phoneNo = 0;
        password = null;
    }

    public static Admin getAdmin(){
        return admin;
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
