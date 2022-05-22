package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.Admin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAIViewController implements Initializable {

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField PhoneNoField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NameField.setText(Admin.getAdmin().getName());
        EmailField.setText(Admin.getAdmin().getEmail());
        PhoneNoField.setText('0'+String.valueOf(Admin.getAdmin().getPhoneNo()));
    }

}
