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

public class Start {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonDoctor;

    @FXML
    private Button ButtonUser;

    @FXML
    void ClickDoctor(MouseEvent event) {
        try {
            Parent doctorLoginRoot = FXMLLoader.load(getClass().getResource("doctorLogin.fxml"));
            Scene doctorLoginScene = new Scene(doctorLoginRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(doctorLoginScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickUser(MouseEvent event) {
        try {
            Parent userLoginRoot = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
            Scene userLoginScene = new Scene(userLoginRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(userLoginScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert ButtonDoctor != null : "fx:id=\"ButtonDoctor\" was not injected: check your FXML file 'start.fxml'.";
        assert ButtonUser != null : "fx:id=\"ButtonUser\" was not injected: check your FXML file 'start.fxml'.";

    }

}
