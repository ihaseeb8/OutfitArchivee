package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.HelloApplication;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminViewController {

    @FXML
    private Button AIButton;

    @FXML
    private Button AOButton;

    @FXML
    private Button APButton;

    @FXML
    private Button LOButton;

    @FXML
    private Button POButton;

    @FXML
    private Button RPButton;

    @FXML
    private BorderPane mainPane;

    @FXML
    void AIButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/admin-ai-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void AOButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/admin-ao-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void APButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/admin-ap-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void APButtonME(MouseEvent event) {
        APButton.setStyle("-fx-background-color: #FFFFFF");
        APButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void LOButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/admin-login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void POButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/admin-po-view.fxml"));
        mainPane.setCenter(view1);
    }

    @FXML
    void RPButtonClicked(MouseEvent event) throws IOException {
        Pane view1 = new FXMLLoader().load(HelloApplication.class.getResource("FXMLFiles/admin-rp-view.fxml"));
        mainPane.setCenter(view1);
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
    void onAOButtonME(MouseEvent event) {
        AOButton.setStyle("-fx-background-color: #FFFFFF");
        AOButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onAOButtonMM(MouseEvent event) {
        AOButton.setStyle("-fx-background-color: #212121");
        AOButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onAPButtonMM(MouseEvent event) {
        APButton.setStyle("-fx-background-color: #212121");
        APButton.setTextFill(Paint.valueOf("#FFFFFF"));
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

    @FXML
    void onPOButtonME(MouseEvent event) {
        POButton.setStyle("-fx-background-color: #FFFFFF");
        POButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onPOButtonMM(MouseEvent event) {
        POButton.setStyle("-fx-background-color: #212121");
        POButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onRPButtonME(MouseEvent event) {
        RPButton.setStyle("-fx-background-color: #FFFFFF");
        RPButton.setTextFill(Paint.valueOf("#212121"));
    }

    @FXML
    void onRPButtonMM(MouseEvent event) {
        RPButton.setStyle("-fx-background-color: #212121");
        RPButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

}
