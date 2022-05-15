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

public class UserShopViewController {

    @FXML
    private Button BackButton;

    @FXML
    void onBackButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBackButtonME(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #FFFFFF");
        BackButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onBackButtonMM(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #212121");
        BackButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

}
