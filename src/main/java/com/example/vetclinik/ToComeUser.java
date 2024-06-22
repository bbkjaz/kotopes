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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ToComeUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button login;

    @FXML
    private Label passwordField;

    @FXML
    private Label phoneNumberField;

    @FXML
    void login(MouseEvent event) {
        // Проверяем введенные данные
        String phoneNumber = phoneNumberField.getText();
        String password = passwordField.getText();

        if (isValidLogin(phoneNumber, password)) {
            // Успешный вход
            login.setStyle("-fx-background-color: green;");
            openUserAccountWindow();
        } else {
            // Неуспешный вход
            login.setStyle("-fx-background-color: red;");
        }
    }

    private boolean isValidLogin(String phoneNumber, String password) {
        // Здесь должна быть проверка введенных данных, например, сравнение с хранящимися данными в системе
        // В данном примере просто возвращаем true для демонстрации успешного входа
        return true;
    }

    @FXML
    void toBack() {
        try {
            Parent userLoginRoot = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
            Scene userLoginScene = new Scene(userLoginRoot);
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(userLoginScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openUserAccountWindow() {
        try {
            Parent userAccountRoot = FXMLLoader.load(getClass().getResource("userAccount.fxml"));
            Scene userAccountScene = new Scene(userAccountRoot);
            Stage window = (Stage) login.getScene().getWindow();
            window.setScene(userAccountScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'toComeUser.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'toComeUser.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'toComeUser.fxml'.";
        assert phoneNumberField != null : "fx:id=\"phoneNumberField\" was not injected: check your FXML file 'toComeUser.fxml'.";

    }

}


    /*@FXML
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
*/


