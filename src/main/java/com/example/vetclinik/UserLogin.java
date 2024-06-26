package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserLogin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button loginToAccountUser;

    @FXML
    private Button registrationUser;


    @FXML
    void ClickLoginToAccountUser(MouseEvent event) {
        try {
            Parent toComeUserRoot = FXMLLoader.load(getClass().getResource("toComeUser.fxml"));
            Scene toComeUserScene = new Scene(toComeUserRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(toComeUserScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickRegistrationUser(MouseEvent event) {
        try {
            Parent registrationRoot = FXMLLoader.load(getClass().getResource("userRegistration.fxml"));
            Scene registrationScene = new Scene(registrationRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(registrationScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toBack(MouseEvent event) {
        try {
            Parent startRoot = FXMLLoader.load(getClass().getResource("start.fxml"));
            Scene startScene = new Scene(startRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(startScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'userLogin.fxml'.";
        assert loginToAccountUser != null : "fx:id=\"loginToAccountUser\" was not injected: check your FXML file 'userLogin.fxml'.";
        assert registrationUser != null : "fx:id=\"registrationUser\" was not injected: check your FXML file 'userLogin.fxml'.";

    }
}
