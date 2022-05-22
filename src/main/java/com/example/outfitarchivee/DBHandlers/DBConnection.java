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

    public boolean searchProduct(String prodId){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT id FROM ap.oaproducts WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            //String id = String.valueOf(prodId);

            statement.setString(1, prodId);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                String idFetched = rs.getString("id"); // by column name matchin

                if( idFetched.equalsIgnoreCase( prodId) ) {

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

    public boolean insertProduct(String id, double price, int quantity, String name, String color,String size,String description, String type,String gender){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.oaproducts(id,name,type,color,size,description,price,quantity,gender) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, type);
            statement.setString(4, color);
            statement.setString(5, size);
            statement.setString(6, description);
            statement.setString(7, String.valueOf(price));
            statement.setString(8, String.valueOf(quantity));
            statement.setString(9, gender);

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

    public boolean removeProduct(String id){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");


            String sql = "DELETE FROM ap.oaproducts WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, id);

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

    public ObservableList<Product> getAvailableProducts(){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "SELECT * FROM ap.oaproducts WHERE quantity > ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(0));

            ResultSet rs = statement.executeQuery();

            ObservableList<Product> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setId(rs.getString("id"));
                product.setColor(rs.getString("color"));
                product.setPrice(Double.valueOf(rs.getString("price")));
                product.setDescription(rs.getString("description"));
                product.setGender(rs.getString("gender"));
                product.setQuantity(Integer.valueOf(rs.getString("quantity")));
                product.setSize(rs.getString("size"));
                product.setType(rs.getString("type"));

                returnlist.add(product);
            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public boolean insertOrder(String phoneNo){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.oaorders(userPhoneNo) VALUES (?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, phoneNo);
            int rowIns = statement.executeUpdate();

            //System.out.println(rowIns);
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

    public boolean updateOrderBill(int orderId, double bill ){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "UPDATE ap.oaorders SET bill = ? WHERE (id = ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(bill));

            statement.setString(2, String.valueOf(orderId));

            int rowIns = statement.executeUpdate();

            //System.out.println(rowIns);
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

    public boolean insertOrderLine(int ordId, String prodId, double price , int quantity, double total){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.oaorderlines(orderId , productId , price , quantity, total) VALUES (? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(ordId));
            statement.setString(2, prodId);
            statement.setString(3, String.valueOf(price));
            statement.setString(4, String.valueOf(quantity));
            statement.setString(5, String.valueOf(total));

            int rowIns = statement.executeUpdate();

            //System.out.println(rowIns);
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

    public void insertOrderLines(){

        double totalBill = 0;

        int orderId = getLastInsertedId();
        if(orderId > 0) {
            for (Product product : ShoppingCart.getCart().getItems()) {
                insertOrderLine(orderId, product.getId(), product.getPrice() , product.getQuantity() , (product.getPrice()*product.getQuantity()));

                totalBill = totalBill + (product.getPrice()*product.getQuantity());
            }

            System.out.println(totalBill);
            updateOrderBill(orderId,totalBill);
        }
        else
        {
            System.out.println("error");
        }
    }

    public int getLastInsertedId(){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT MAX(id) AS MaxId FROM ap.oaorders";

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            rs.next();

            int maxId = Integer.valueOf(rs.getString("MaxId"));

            System.out.println(maxId);
            con.close();

            if(maxId > 0)
                return maxId;
            else
                return -1;

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return -1;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return -1;
        }
    }

    public ObservableList<Order> getOrders(){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "SELECT * FROM ap.oaorders WHERE userPhoneNo = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(User.getUser().getPhoneNo()));

            ResultSet rs = statement.executeQuery();

            ObservableList<Order> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {

                Order order = new Order();
                order.setId(Integer.valueOf(rs.getString("id")));
                order.setPhoneNo(rs.getString("userPhoneNo"));
                order.setBill(Double.valueOf(rs.getString("bill")));
                order.setStatus(rs.getString("status"));
                returnlist.add(order);
            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<OrderLine> getOrderLines(int orderId) {
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "SELECT * FROM ap.oaorderlines WHERE orderId = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(orderId));

            ResultSet rs = statement.executeQuery();

            ObservableList<OrderLine> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {

                OrderLine orderline = new OrderLine();
                orderline.setOrderId(Integer.valueOf(rs.getString("orderId")));
                orderline.setProductId(rs.getString("productId"));
                orderline.setPrice(Double.valueOf(rs.getString("price")));
                orderline.setTotal(Double.valueOf(rs.getString("total")));
                orderline.setQuantity(Integer.valueOf(rs.getString("quantity")));

                returnlist.add(orderline);
            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public boolean updateOrderStatus(int id, String newStatus) {

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "UPDATE ap.oaorders SET status = ? WHERE (id = ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, newStatus);

            statement.setString(2, String.valueOf(id));

            int rowIns = statement.executeUpdate();

            //System.out.println(rowIns);
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

    public ObservableList<Order> getStatusOrders(String status){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "SELECT * FROM ap.oaorders WHERE status = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, status);

            ResultSet rs = statement.executeQuery();

            ObservableList<Order> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {

                Order order = new Order();
                order.setId(Integer.valueOf(rs.getString("id")));
                order.setPhoneNo(rs.getString("userPhoneNo"));
                order.setBill(Double.valueOf(rs.getString("bill")));
                order.setStatus(rs.getString("status"));
                returnlist.add(order);
            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Order> getAllOrders(){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.oaorders WHERE status != 'WaitingApproval' ";

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            ObservableList<Order> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {

                Order order = new Order();
                order.setId(Integer.valueOf(rs.getString("id")));
                order.setPhoneNo(rs.getString("userPhoneNo"));
                order.setBill(Double.valueOf(rs.getString("bill")));
                order.setStatus(rs.getString("status"));
                returnlist.add(order);
            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

}

