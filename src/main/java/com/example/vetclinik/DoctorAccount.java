package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DoctorAccount {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label adres;

    @FXML
    private Button back;

    @FXML
    private Button directory;

    @FXML
    private Button myTricks;

    @FXML
    private Label name;

    @FXML
    private Label number;
    @FXML
    private Button reception;

    @FXML
    private Button toChangeData;
    private DoctorSQL doctorSQL;
    public DoctorAccount(){
        doctorSQL = DoctorSQL.getInstance();
    }

    @FXML
    void directory(MouseEvent event) {
        try {
            Parent directoryRoot = FXMLLoader.load(getClass().getResource("directory.fxml"));
            Scene directoryScene = new Scene(directoryRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(directoryScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void myTricks(MouseEvent event) {
        try {
            Parent tricksRoot = FXMLLoader.load(getClass().getResource("doctorTricks.fxml"));
            Scene tricksScene = new Scene(tricksRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(tricksScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toBack(MouseEvent event) {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("toComeDoctor.fxml"));
            Scene loginScene = new Scene(loginRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toChangeData(MouseEvent event) {
        try {
            Parent changeDataRoot = FXMLLoader.load(getClass().getResource("changeDoctor.fxml"));
            Scene changeDataScene = new Scene(changeDataRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(changeDataScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void toRecep(ActionEvent event) {
        try {
            Parent changeDataRoot = FXMLLoader.load(getClass().getResource("recep.fxml"));
            Scene changeDataScene = new Scene(changeDataRoot);
            Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
            window.setScene(changeDataScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void initialize() {
        assert adres != null : "fx:id=\"adres\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert directory != null : "fx:id=\"directory\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert myTricks != null : "fx:id=\"myTricks\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert number != null : "fx:id=\"number\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert reception != null : "fx:id=\"reception\" was not injected: check your FXML file 'doctorAccount.fxml'.";
        assert toChangeData != null : "fx:id=\"toChangeData\" was not injected: check your FXML file 'doctorAccount.fxml'.";

        number.setText(ToComeDoctor.getLog());
        String[] users = doctorSQL.getDoctor(ToComeDoctor.getLog());
        name.setText(users[1]);
        adres.setText(users[2]);
    }

}

