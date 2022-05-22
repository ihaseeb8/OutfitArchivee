package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.Product;
import com.example.outfitarchivee.Classes.ShoppingCart;
import com.example.outfitarchivee.Classes.User;
import com.example.outfitarchivee.DBHandlers.DBConnection;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class UserSIViewController implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private TextField QuantityField;

    @FXML
    private Text promptText;

    @FXML
    private TableColumn<Product, String> ColorCol;

    @FXML
    private TableColumn<Product, String> GenderCol;

    @FXML
    private TableColumn<Product, String> NameCol;

    @FXML
    private TableView<Product> ProductsTable;

    @FXML
    private TableColumn<Product, String> IdCol;

    @FXML
    private TableColumn<Product, Double> PriceCol;

    @FXML
    private TableColumn<Product, Integer> QuantityCol;

    @FXML
    private TableColumn<Product, String> SizeCol;

    @FXML
    private TableColumn<Product, String> TypeCol;

    @FXML
    void onAddButtonME(MouseEvent event) {
        AddButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onAddButtonMM(MouseEvent event) {
        AddButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void AddButtonClicked(MouseEvent event) throws InterruptedException {

        if (ProductsTable.getSelectionModel().isEmpty()) {
            promptText.setText("Please Select an Item First !");
        } else {
            if (QuantityField.getText().isEmpty()) {
                promptText.setText("Please Enter the Quantity !");
            } else {
                try {
                    if (Integer.valueOf(QuantityField.getText()) > ProductsTable.getSelectionModel().getSelectedItem().getQuantity()) {
                        System.out.println(ProductsTable.getSelectionModel().getSelectedItem().getQuantity());
                        System.out.println(Integer.valueOf(QuantityField.getText()));
                        promptText.setText("You cannot order more than available stock");
                    } else {
                        promptText.setText("Item has been successfully added to your cart");
                        Product item = ProductsTable.getSelectionModel().getSelectedItem();
                        item.setQuantity(Integer.valueOf(QuantityField.getText()));
                        //item.setPrice(ProductsTable.getSelectionModel().getSelectedItem().getPrice() * ProductsTable.getSelectionModel().getSelectedItem().getQuantity());
                        ShoppingCart.getCart().addItem(item);

                        PauseTransition delay = new PauseTransition(Duration.seconds(1));
                        delay.setOnFinished(Event -> clearAll());
                        delay.play();
                    }
                } catch (Exception e) {
                    promptText.setText("The Quantity should be in numbers !");
                }

            }

        }

    }

    public void clearAll(){
        promptText.setText("");
        ProductsTable.getSelectionModel().clearSelection();
        QuantityField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Product> data = DBConnection.getDBConnection().getAvailableProducts();

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
