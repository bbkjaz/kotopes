package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ToComeDoctor {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button login;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneNumberField;
    private static String log;
    @FXML
    private Label error;
    private static String password;
    private DoctorSQL doctorSQL;
    public ToComeDoctor(){
        doctorSQL = DoctorSQL.getInstance();
    }
    @FXML
    void login(MouseEvent event) {
        password = passwordField.getText();
        log = phoneNumberField.getText();
        boolean flag = doctorSQL.isUsers(phoneNumberField.getText(), passwordField.getText());
        if(flag) {
            try {

                Parent accountRoot = FXMLLoader.load(getClass().getResource("doctorAccount.fxml"));
                Scene accountScene = new Scene(accountRoot);
                Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
                window.setScene(accountScene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            error.setText("пользователь не найден");

    }

    public static String getLog() {
        return log;
    }

    public static String getPassword() {
        return password;
    }

    @FXML
    void toBack(MouseEvent event) {
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
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'toComeDoctor.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'toComeDoctor.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'toComeDoctor.fxml'.";
        assert phoneNumberField != null : "fx:id=\"phoneNumberField\" was not injected: check your FXML file 'toComeDoctor.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'toComeDoctor.fxml'.";

    }

}
