package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.DBHandlers.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AdminRPViewController {

    @FXML
    private TextField IdField;

    @FXML
    private Button RemoveButton;

    @FXML
    private Text promptText;

    @FXML
    void RemoveButtonClicked(MouseEvent event) {
        if (IdField.getText().isEmpty())
        {
            promptText.setText("Please Enter the Product Id First !");
        }
        else
        {
            DBConnection dbConnection = DBConnection.getDBConnection();

            if(dbConnection.searchProduct(IdField.getText()))
            {
                dbConnection.removeProduct(IdField.getText());
                promptText.setText("Product Removed Successfully !");
            }
            else
            {
                promptText.setText("The Given Id does not match with any product !");
            }
        }
    }

    @FXML
    void onRemoveButtonME(MouseEvent event) {
        RemoveButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onRemoveButtonMM(MouseEvent event) {
        RemoveButton.setStyle("-fx-background-color: #455A64");
    }

}
