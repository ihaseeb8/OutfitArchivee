package com.example.outfitarchivee.Controllers;

import com.example.outfitarchivee.Classes.User;
import com.example.outfitarchivee.DBHandlers.DBConnection;
import com.example.outfitarchivee.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class UserLoginViewController {

    @FXML
    private Button BackButton;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text promptText;

    @FXML
    void onBackButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-view.fxml"));
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

    @FXML
    void onLoginButtonClicked(MouseEvent event) throws IOException {

        if(!PhoneNoField.getText().isEmpty()){

            String phoneNo = PhoneNoField.getText();
            long phNo = Long.parseLong(phoneNo);

            if(phNo < 3000000000L || phNo > 3999999999L)
            {
                promptText.setText("Invalid Phone No!");
            }
            else
            {
                DBConnection dbConnection = DBConnection.getDBConnection();

                if (dbConnection.getUser(phNo) == true) {

                    if(!passwordField.getText().isEmpty())
                    {
                        if(passwordField.getText().equals(User.getUser().getPassword()))
                        {
                            //play sound
                            //ts.run();
                            // set all classes

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/user-shop-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            //Node node = (Node) event.getSource();
                            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        }
                        else
                        {
                            //error sound
                            //te.run();
                            promptText.setText("Incorrect Password!");
                        }

                    }
                    else
                    {
                        //error sound
                        //te.run();
                        promptText.setText("Please Enter Password!");
                    }

                }
                else
                {
                    promptText.setText("Your Mobile No is not registered with us!");
                }

            }
        }
        else
        {
            //error sound
            //te.run();
            promptText.setText("Please Enter Mobile No!");
        }
    }

    @FXML
    void onLoginButtonME(MouseEvent event) {
        LoginButton.setStyle("-fx-background-color: #212121");
    }

    @FXML
    void onLoginButtonMM(MouseEvent event) {
        LoginButton.setStyle("-fx-background-color: #455A64");
    }

}
