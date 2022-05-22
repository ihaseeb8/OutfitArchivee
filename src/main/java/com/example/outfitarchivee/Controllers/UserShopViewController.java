package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class UserShopViewController {

    @FXML
    private Button AIButton;

    @FXML
    private Button LOButton;

    @FXML
    private Button SCButton;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button SIButton;

    @FXML
    private Button PODButton;

    @FXML
    private Button MOButton;

    @FXML
    void PODButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/user-pod-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void onPODButtonME(MouseEvent event) {
        PODButton.setStyle("-fx-background-color: #FFFFFF");
        PODButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onPODButtonMM(MouseEvent event) {
        PODButton.setStyle("-fx-background-color: #212121");
        PODButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onMOButtonME(MouseEvent event) {
        MOButton.setStyle("-fx-background-color: #FFFFFF");
        MOButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onMOButtonMM(MouseEvent event) {
        MOButton.setStyle("-fx-background-color: #212121");
        MOButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void MOButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/user-mo-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void onSCButtonME(MouseEvent event) {
        SCButton.setStyle("-fx-background-color: #FFFFFF");
        SCButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onSCButtonMM(MouseEvent event) {
        SCButton.setStyle("-fx-background-color: #212121");
        SCButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void SCButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/user-sc-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void SIButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/user-si-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void onSIButtonME(MouseEvent event) {
        SIButton.setStyle("-fx-background-color: #FFFFFF");
        SIButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onSIButtonMM(MouseEvent event) {
        SIButton.setStyle("-fx-background-color: #212121");
        SIButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void AIButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/user-ai-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void LOButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAIButtonME(MouseEvent event) {
        AIButton.setStyle("-fx-background-color: #FFFFFF");
        AIButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onAIButtonMM(MouseEvent event) {
        AIButton.setStyle("-fx-background-color: #212121");
        AIButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onLOButtonME(MouseEvent event) {
        LOButton.setStyle("-fx-background-color: #FFFFFF");
        LOButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onLOButtonMM(MouseEvent event) {

        LOButton.setStyle("-fx-background-color: #212121");
        LOButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }


}
