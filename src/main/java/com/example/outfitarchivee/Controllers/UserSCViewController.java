package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.Product;
import com.example.outfitarchivee.Classes.ShoppingCart;
import com.example.outfitarchivee.Classes.User;
import com.example.outfitarchivee.DBHandlers.DBConnection;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class UserSCViewController implements Initializable {

    @FXML
    private Button POButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TableColumn<Product, String> ColorCol;

    @FXML
    private TableColumn<Product, String> GenderCol;

    @FXML
    private TableColumn<Product, String> NameCol;

    @FXML
    private TableView<Product> ProductsTable;

    @FXML
    private TableColumn<Product, Double> PriceCol;

    @FXML
    private TableColumn<Product, Integer> QuantityCol;

    @FXML
    private TableColumn<Product, String> SizeCol;

    @FXML
    private TableColumn<Product, String> IdCol;

    @FXML
    private TableColumn<Product, String> TypeCol;

    @FXML
    private Text promptText;

    @FXML
    void POButtonClicked(MouseEvent event) {
        if(ShoppingCart.getCart().getItems().isEmpty())
        {
            promptText.setText("Please Add Items to your Cart Before Placing an Order !");
        }
        else {

            promptText.setText("Hold on, We are Placing Your Order !");

            DBConnection.getDBConnection().insertOrder(String.valueOf(User.getUser().getPhoneNo()));
            DBConnection.getDBConnection().insertOrderLines();

            ObservableList<Product> items= FXCollections.observableArrayList();
            ShoppingCart.getCart().setItems(items);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(Event -> reset());
            delay.play();

        }
    }

    @FXML
    void onPOButtonME(MouseEvent event) {
        POButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onPOButtonMM(MouseEvent event) {
        POButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void DeleteButtonClicked(MouseEvent event) {
        if (ProductsTable.getSelectionModel().isEmpty()) {
            promptText.setText("Please Select an Item First !");
        }
        else{

            promptText.setText("Item has been removed successfully !");

            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(Event -> clearAll());
            delay.play();

            return;
        }

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(Event -> promptText.setText(""));
        delay.play();
    }

    public void clearAll(){
        Product item = ProductsTable.getSelectionModel().getSelectedItem();
        ShoppingCart.getCart().removeItem(item);
        promptText.setText("");
        ProductsTable.getSelectionModel().clearSelection();
    }

    @FXML
    void onDeleteButtonME(MouseEvent event) {
        DeleteButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onDeleteButtonMM(MouseEvent event) {
        DeleteButton.setStyle("-fx-background-color: #455A64");
    }

    public void reset(){
        ObservableList<Product> data = ShoppingCart.getCart().getItems();
        ProductsTable.setItems(data);
        promptText.setText("Order Placed Successfully");

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(Event -> promptText.setText(""));
        delay.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Product> data = ShoppingCart.getCart().getItems();

        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        ColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        SizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        GenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        if(data != null) {
            ProductsTable.setItems(data);
        }

    }
}
