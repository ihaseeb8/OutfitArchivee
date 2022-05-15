package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button AdminButton;

    @FXML
    private Button UserButton;

    @FXML
    void onAdminButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/admin-login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onAdminButtonME(MouseEvent event) {
        AdminButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onAdminButtonMM(MouseEvent event) {
        AdminButton.setStyle("-fx-background-color: #455A64");
    }

    @FXML
    void onUserButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onUserButtonME(MouseEvent event) {
        UserButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onUserButtonMM(MouseEvent event) {
        UserButton.setStyle("-fx-background-color: #455A64");
    }

}
