package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.Order;
import com.example.outfitarchivee.Classes.Product;
import com.example.outfitarchivee.Classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UserPODViewController implements Initializable {

    @FXML
    private TableColumn<Order, Integer> BillCol;

    @FXML
    private TableColumn<Order, String> IdCol;

    @FXML
    private TableView<Order> OrdersTable;

    @FXML
    private TableColumn<Order, String> PhoneCol;

    @FXML
    private TableColumn<Order, String> StatusCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Order> orders = User.getUser().getOrders();
        ObservableList<Order> temporders = FXCollections.observableArrayList();

        for(Order order : orders)
        {
            if(!order.getStatus().equals("NotPlacedYet"))
                temporders.add(order);
        }

        orders = temporders;

        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        PhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        BillCol.setCellValueFactory(new PropertyValueFactory<>("bill"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        if(orders != null) {
            OrdersTable.setItems(orders);
        }
    }
}
