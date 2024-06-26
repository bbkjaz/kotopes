package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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

public class UserRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adres;
    @FXML
    private Label errorText;

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
    private UserSQL userSQL;
    public UserRegistration(){
        userSQL = UserSQL.getInstance();
    }

    @FXML
    void registration(ActionEvent event) {
        try {
            if (name.getText().isEmpty() & password.getText().isEmpty() & number.getText().isEmpty() & adres.getText().isEmpty() & password.getText().isEmpty()) {
                errorText.setText("заполните все поля");
            }
            else {
                boolean flag = userSQL.addUser(name.getText(),number.getText(),adres.getText(),password.getText());
                if (flag) {
                    Parent userAccountRoot = FXMLLoader.load(getClass().getResource("toComeUser.fxml"));
                    Scene userAccountScene = new Scene(userAccountRoot);
                    Stage window = (Stage) registration.getScene().getWindow();
                    window.setScene(userAccountScene);
                    window.show();
                }
                else {
                    System.out.println("ошибка");
                }
            }


        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toBack(MouseEvent event) {
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
    @FXML
    void initialize() {
        assert adres != null : "fx:id=\"adres\" was not injected: check your FXML file 'userRegistration.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'userRegistration.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'userRegistration.fxml'.";
        assert number != null : "fx:id=\"number\" was not injected: check your FXML file 'userRegistration.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'userRegistration.fxml'.";
        assert registration != null : "fx:id=\"registration\" was not injected: check your FXML file 'userRegistration.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'userRegistration.fxml'.";

    }

}


