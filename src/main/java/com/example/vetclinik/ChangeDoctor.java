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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChangeDoctor {

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
    private TextField password;

    @FXML
    private Label phone;

    @FXML
    private Button save;
    private String[] user;
    private DoctorSQL doctorSQL;
    public ChangeDoctor(){
        doctorSQL = DoctorSQL.getInstance();
        user = doctorSQL.getDoctor(ToComeDoctor.getLog());
    }

    @FXML
    void toBack(MouseEvent event) {
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

    @FXML
    void toSave(MouseEvent event) {
        if (doctorSQL.updateName(Integer.parseInt(user[0]), name.getText()) &
                doctorSQL.updateAdress(Integer.parseInt(user[0]), adres.getText())) {
            try {
                Parent userAccountRoot = FXMLLoader.load(getClass().getResource("doctorAccount.fxml"));
                Scene userAccountScene = new Scene(userAccountRoot);
                Stage window = (Stage) back.getScene().getWindow();
                window.setScene(userAccountScene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize() {
        assert adres != null : "fx:id=\"adres\" was not injected: check your FXML file 'changeDoctor.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'changeDoctor.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'changeDoctor.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'changeDoctor.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'changeDoctor.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'changeDoctor.fxml'.";
        phone.setText(ToComeDoctor.getLog());
        name.setText(user[1]);
        adres.setText(user[2]);
    }

}
