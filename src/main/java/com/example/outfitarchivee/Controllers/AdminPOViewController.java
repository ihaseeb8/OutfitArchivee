package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.*;
import com.example.outfitarchivee.DBHandlers.DBConnection;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminPOViewController implements Initializable {

    @FXML
    private TableColumn<Order, Double> BillCol;

    @FXML
    private Button ViewDetailsButton;

    @FXML
    private TableColumn<Order, Double> IdCol;

    @FXML
    private TableColumn<OrderLine, String> ItemIdCol;

    @FXML
    private TableColumn<OrderLine, Double> ItemPriceCol;

    @FXML
    private TableColumn<OrderLine, Integer> ItemQuantityCol;

    @FXML
    private TableColumn<OrderLine, Integer> OrderIdCol;

    @FXML
    private TableView<OrderLine> OrderLinesTable;

    @FXML
    private TableView<Order> OrdersTable;

    @FXML
    private Button POButton;

    @FXML
    private TableColumn<Order, String> PhoneCol;

    @FXML
    private TableColumn<Order, String> StatusCol;

    @FXML
    private TableColumn<OrderLine, Double> TotalPriceCol;

    @FXML
    private Text promptText;

    @FXML
    private Button ROButton;

    @FXML
    void onROButtonME(MouseEvent event) {
        ROButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onROButtonMM(MouseEvent event) {
        ROButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void ROButtonClicked(MouseEvent event) {
        if(OrdersTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select An order from above first !");
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(Event -> promptText.setText(""));
            delay.play();
        }
        else
        {
            int orderid = OrdersTable.getSelectionModel().getSelectedItem().getId();
            String status = OrdersTable.getSelectionModel().getSelectedItem().getStatus();

            if(status.equals("WaitingApproval")) {
                promptText.setText("Rejecting Selected Order.... !");
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(Event -> promptText.setText(""));
                delay.play();

                DBConnection.getDBConnection().updateOrderStatus(orderid,"Rejected");

                promptText.setText("Order Rejected Successfully !");
                PauseTransition delay1 = new PauseTransition(Duration.seconds(1));
                delay1.setOnFinished(Event -> promptText.setText(""));
                delay1.play();

                PauseTransition delay2 = new PauseTransition(Duration.seconds(1));
                delay2.setOnFinished(Event -> refreshAll(1));
                delay2.play();
            }
        }
    }

    @FXML
    void ViewDetailsButtonClicked(MouseEvent event) {

        ObservableList<OrderLine> empty = FXCollections.observableArrayList();
        OrderLinesTable.setItems(empty);

        if(OrdersTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select An order from above first !");
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(Event -> promptText.setText(""));
            delay.play();
        }
        else
        {
            int orderid = OrdersTable.getSelectionModel().getSelectedItem().getId();

            ObservableList<OrderLine> orderlines = DBConnection.getDBConnection().getOrderLines(orderid);

            OrderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderId"));
            ItemIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));
            ItemPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            ItemQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            TotalPriceCol.setCellValueFactory(new PropertyValueFactory<>("total"));

            promptText.setText("Bringing your Order Details in the table below !");
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(Event -> promptText.setText(""));
            delay.play();

            if(orderlines != null) {
                PauseTransition delay2 = new PauseTransition(Duration.seconds(1));
                delay2.setOnFinished(Event -> OrderLinesTable.setItems(orderlines) );
                delay2.play();
            }

            PauseTransition delay2 = new PauseTransition(Duration.seconds(2));
            delay2.setOnFinished(Event -> OrdersTable.getSelectionModel().clearSelection());
            delay2.play();
        }
    }

    @FXML
    void POButtonClicked(MouseEvent event) {
        if(OrdersTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select An order from above first !");
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(Event -> promptText.setText(""));
            delay.play();
        }
        else
        {
            int orderid = OrdersTable.getSelectionModel().getSelectedItem().getId();
            String status = OrdersTable.getSelectionModel().getSelectedItem().getStatus();

            if(status.equals("WaitingApproval")) {
                promptText.setText("Confirming Selected Order.... !");
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(Event -> promptText.setText(""));
                delay.play();

                DBConnection.getDBConnection().updateOrderStatus(orderid,"Confirmed");

                promptText.setText("Order Confirmed Successfully !");
                PauseTransition delay1 = new PauseTransition(Duration.seconds(1));
                delay1.setOnFinished(Event -> promptText.setText(""));
                delay1.play();

                PauseTransition delay2 = new PauseTransition(Duration.seconds(1));
                delay2.setOnFinished(Event -> refreshAll(1));
                delay2.play();
            }
        }
    }

    @FXML
    void onViewDetailsButtonME(MouseEvent event) {
        ViewDetailsButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onViewDetailsButtonMM(MouseEvent event) {
        ViewDetailsButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void onPOButtonME(MouseEvent event) {
        POButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onPOButtonMM(MouseEvent event) {
        POButton.setStyle("-fx-background-color: #455A64");
    }

    public void refreshAll(int val){

        ObservableList<OrderLine> empty = FXCollections.observableArrayList();
        OrderLinesTable.setItems(empty);
        OrdersTable.getSelectionModel().clearSelection();

        if(val > 0)
        {
            ObservableList<Order> orders = DBConnection.getDBConnection().getStatusOrders("WaitingApproval");
            OrdersTable.setItems(orders);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Order> orders = DBConnection.getDBConnection().getStatusOrders("WaitingApproval");

        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        PhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        BillCol.setCellValueFactory(new PropertyValueFactory<>("bill"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        if(orders != null) {
            OrdersTable.setItems(orders);
        }
    }
}

