package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserAccount {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button makeAnAppointment;

    @FXML
    private Button myTricks;

    @FXML
    private Button toChangeData;

    @FXML
    void makeAnAppointment(KeyEvent event) {

    }

    @FXML
    void myTricks(MouseEvent event) {

    }

    @FXML
    void toBack(MouseEvent event) {
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
    void toChangeData(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'userAccount.fxml'.";
        assert makeAnAppointment != null : "fx:id=\"makeAnAppointment\" was not injected: check your FXML file 'userAccount.fxml'.";
        assert myTricks != null : "fx:id=\"myTricks\" was not injected: check your FXML file 'userAccount.fxml'.";
        assert toChangeData != null : "fx:id=\"toChangeData\" was not injected: check your FXML file 'userAccount.fxml'.";

    }

}
