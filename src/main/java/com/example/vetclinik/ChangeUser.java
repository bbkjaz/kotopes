package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChangeUser {

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
    private TextField password;

    @FXML
    private Button save;

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
    void toSave(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert adres != null : "fx:id=\"adres\" was not injected: check your FXML file 'changeUser.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'changeUser.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'changeUser.fxml'.";
        assert number != null : "fx:id=\"number\" was not injected: check your FXML file 'changeUser.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'changeUser.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'changeUser.fxml'.";

    }

}
