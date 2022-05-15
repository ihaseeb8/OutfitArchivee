package com.example.outfitarchivee.DBHandlers;

import com.example.outfitarchivee.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import static java.lang.Integer.parseInt;

public class DBConnection {

    private static DBConnection obj=new DBConnection();

    private DBConnection(){

    }

    public static DBConnection getDBConnection(){
        return obj;
    }


    public boolean searchUser(long phoneNo){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT phoneNo FROM ap.oausers WHERE phoneNo = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            String phNo = String.valueOf(phoneNo);

            statement.setString(1, phNo);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                String phNoFetched = rs.getString("phoneNo"); // by column name matchin

                long fethcedno = Long.parseLong(phNoFetched);

                if( fethcedno == phoneNo ) {
                    return true;
                }

            }

            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean getAdmin(long phNo){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.oaadmins WHERE phoneNo = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            String phoneNo = String.valueOf(phNo);

            statement.setString(1, phoneNo);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                Admin.getAdmin().setPhoneNo( Long.parseLong(rs.getString("phoneNo"))); // by column name matchin
                Admin.getAdmin().setName(rs.getString("name"));
                Admin.getAdmin().setEmail(rs.getString("email"));
                Admin.getAdmin().setPassword(rs.getString("password"));

                if( Long.parseLong(rs.getString("phoneNo")) == phNo ) {
                    return true;
                }

            }
            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean getUser(long phNo){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.oausers WHERE phoneNo = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            String phoneNo = String.valueOf(phNo);

            statement.setString(1, phoneNo);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                User.getUser().setPhoneNo( Long.parseLong(rs.getString("phoneNo"))); // by column name matchin
                User.getUser().setName(rs.getString("username"));
                User.getUser().setEmail(rs.getString("email"));
                User.getUser().setPassword(rs.getString("password"));
                User.getUser().setAddress(rs.getString("address"));

                if( Long.parseLong(rs.getString("phoneNo")) == phNo ) {
                    return true;
                }

            }
            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;

    }

    public boolean insertUser(String name, String phoneNo, String email , String address, String password){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.oausers(username,email,password,phoneNo,address) VALUES (? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phoneNo);
            statement.setString(5, address);
            int rowIns = statement.executeUpdate();

            con.close();

            if(rowIns > 0)
                return true;
            else
                return false;


        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }


}

