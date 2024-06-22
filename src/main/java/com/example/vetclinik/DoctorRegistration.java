package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DoctorRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adres;

    @FXML
    private Button back;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private PasswordField password;

    @FXML
    private Button registration;

    @FXML
    void registration(MouseEvent event) {
        try {
            // Сохранение данных о регистрации можно добавить сюда
            // Например, сохранение в базе данных или файл

            // Переход на страницу аккаунта
            Parent accountRoot = FXMLLoader.load(getClass().getResource("doctorAccount.fxml"));
            Scene accountScene = new Scene(accountRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(accountScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toBack(MouseEvent event) {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("doctorLogin.fxml"));
            Scene loginScene = new Scene(loginRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert adres != null : "fx:id=\"adres\" was not injected: check your FXML file 'doctorRegistration.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'doctorRegistration.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'doctorRegistration.fxml'.";
        assert number != null : "fx:id=\"number\" was not injected: check your FXML file 'doctorRegistration.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'doctorRegistration.fxml'.";
        assert registration != null : "fx:id=\"registration\" was not injected: check your FXML file 'doctorRegistration.fxml'.";

    }

}
