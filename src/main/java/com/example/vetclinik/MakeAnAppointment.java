package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MakeAnAppointment {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private CheckBox clicker;

    @FXML
    private DatePicker date;

    @FXML
    private Button recording;

    @FXML
    private ChoiceBox<?> time;

    @FXML
    void clicker(MouseEvent event) {

    }

    @FXML
    void recording(MouseEvent event) {
        try {
            Parent successfulRegistrationRoot = FXMLLoader.load(getClass().getResource("successfulRegistration.fxml"));
            Scene successfulRegistrationScene = new Scene(successfulRegistrationRoot);
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(successfulRegistrationScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toBack(MouseEvent event) {
        try {
            Parent userAccountRoot = FXMLLoader.load(getClass().getResource("userAccount.fxml"));
            Scene userAccountScene = new Scene(userAccountRoot);
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(userAccountScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert clicker != null : "fx:id=\"clicker\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert recording != null : "fx:id=\"recording\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";

    }

}
