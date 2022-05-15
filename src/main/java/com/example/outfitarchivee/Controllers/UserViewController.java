package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UserViewController {

    @FXML
    private Button CWLButton;

    @FXML
    private Button LoginButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void onLoginButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onLoginButtonME(MouseEvent event) {
        LoginButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onLoginButtonMM(MouseEvent event) {
        LoginButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void onSignUpButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSignUpButtonME(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onSignUpButtonMM(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #455A64");
    }

}
