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

public class DoctorLogin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button loginAccountDoctor;

    @FXML
    private Button registrationDoctor;

    @FXML
    void loginToAccountDoctor(MouseEvent event) {
        try {
            Parent toComeDoctorRoot = FXMLLoader.load(getClass().getResource("toComeDoctor.fxml"));
            Scene toComeDoctorScene = new Scene(toComeDoctorRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(toComeDoctorScene);
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
    void toRegistrationDoctor(MouseEvent event) {
        try {
            Parent registrationRoot = FXMLLoader.load(getClass().getResource("doctorRegistration.fxml"));
            Scene registrationScene = new Scene(registrationRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(registrationScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'doctorLogin.fxml'.";
        assert loginAccountDoctor != null : "fx:id=\"loginAccountDoctor\" was not injected: check your FXML file 'doctorLogin.fxml'.";
        assert registrationDoctor != null : "fx:id=\"registrationDoctor\" was not injected: check your FXML file 'doctorLogin.fxml'.";

    }

}
