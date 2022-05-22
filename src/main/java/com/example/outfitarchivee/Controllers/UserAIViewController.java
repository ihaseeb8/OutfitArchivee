package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.Admin;
import com.example.outfitarchivee.Classes.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserAIViewController implements Initializable {

    @FXML
    private TextField AddressField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField PhoneNoField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NameField.setText(User.getUser().getName());
        EmailField.setText(User.getUser().getEmail());
        AddressField.setText(User.getUser().getAddress());
        PhoneNoField.setText('0'+String.valueOf(User.getUser().getPhoneNo()));
    }
}
