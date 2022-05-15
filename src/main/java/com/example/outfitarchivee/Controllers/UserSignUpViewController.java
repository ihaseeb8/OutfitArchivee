package com.example.outfitarchivee.Controllers;

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

public class UserSignUpViewController {

    @FXML
    private Button BackButton;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private TextField AddressField;

    @FXML
    private Button SignUpButton;

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
    void onSignUpButtonClicked(MouseEvent event) {

        if(NameField.getText().isEmpty())
        {
            //sound
            //te.run();
            promptText.setText("Name cannot be empty!");
        }
        else if(PhoneNoField.getText().isEmpty())
        {
            promptText.setText("Mobile No cannot be empty!");
        }
        else if(EmailField.getText().isEmpty())
        {
            promptText.setText("Email cannot be empty!");
        }
        else if(AddressField.getText().isEmpty())
        {
            promptText.setText("Address cannot be empty!");
        }
        else if(passwordField.getText().isEmpty())
        {
            promptText.setText("Password cannot be empty!");
        }
        else
        {
            String phoneNo = PhoneNoField.getText();
            try
            {
                long phNo = Long.parseLong(phoneNo);

                if(phNo < 3000000000L || phNo > 3999999999L)
                {
                    promptText.setText("Invalid Phone No!");
                }
                else
                {
                    DBConnection dbConnection = DBConnection.getDBConnection();

                    if (dbConnection.searchUser(phNo) == true)
                    {
                        //sound
                        //te.run();
                        promptText.setText("Phone No Already Registered!");
                    }
                    else
                    {
                        phoneNo = String.valueOf(phNo);

                        dbConnection.insertUser(NameField.getText(),phoneNo,EmailField.getText(), AddressField.getText() , passwordField.getText());
                        promptText.setText("You are registered Successfully!");
                        //signupPrompt.setText("You account has been registered");
                    }
                }

            } catch (Exception e) {
                promptText.setText("Invalid Phone Number Format!");
                System.out.println(e.getCause());
            }
        }
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
