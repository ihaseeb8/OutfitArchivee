package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.DBHandlers.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAPViewController implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private Text promptText;

    @FXML
    private ComboBox<String> ColorBox;

    @FXML
    private TextField DescriptionFiled;

    @FXML
    private ComboBox<String> GenderBox;

    @FXML
    private TextField IdField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField PriceField;

    @FXML
    private TextField QuantityField;

    @FXML
    private ComboBox<String> SizeBox;

    @FXML
    private ComboBox<String> TypeBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //list for colors
        ObservableList<String> colors = FXCollections.observableArrayList();
        colors.add("White");
        colors.add("Black");
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Pink");
        colors.add("Orange");

        //list for genders
        ObservableList<String> genders = FXCollections.observableArrayList();
        genders.add("Male");
        genders.add("Female");

        //list for types
        ObservableList<String> types = FXCollections.observableArrayList();
        types.add("Pant");
        types.add("Trouser");
        types.add("Shirt");
        types.add("SweatShirt");
        types.add("Sweater");
        types.add("Jacket");
        types.add("Hoodie");
        types.add("TurtleNeck");

        // list for sizes
        ObservableList<String> sizes = FXCollections.observableArrayList();
        sizes.add("XS");
        sizes.add("S");
        sizes.add("M");
        sizes.add("L");
        sizes.add("XL");
        sizes.add("XXL");


        ColorBox.setItems(colors);
        GenderBox.setItems(genders);
        TypeBox.setItems(types);
        SizeBox.setItems(sizes);
    }

    @FXML
    void onAddButtonME(MouseEvent event) {
        AddButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onAddButtonMM(MouseEvent event) {
        AddButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void AddButtonClicked(MouseEvent event) {

        if (IdField.getText().isEmpty() || NameField.getText().isEmpty() || ColorBox.getValue().isEmpty()
                || TypeBox.getValue().isEmpty() || SizeBox.getValue().isEmpty() || GenderBox.getValue().isEmpty()
                || PriceField.getText().isEmpty() || QuantityField.getText().isEmpty() || DescriptionFiled.getText().isEmpty()) {

            promptText.setText("Please Fill All The Fields !");
        }
        else {
            DBConnection dbConnection = DBConnection.getDBConnection();

            if( dbConnection.searchProduct(IdField.getText()) )
            {
                promptText.setText("Product with the same Id Already Exists!");
            }
            else
            {
                try {
                    dbConnection.insertProduct(IdField.getText(), Double.valueOf(PriceField.getText()), Integer.valueOf(QuantityField.getText()),
                            NameField.getText(), ColorBox.getValue(), SizeBox.getValue(), DescriptionFiled.getText(), TypeBox.getValue(), GenderBox.getValue());

                    promptText.setText("Product Added Successfully !");
                }
                catch (Exception e){
                    promptText.setText("Price/Quantity Value Should be Integer!");
                }
            }
        }


    }
}
