package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class MyTricks {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;
    @FXML
    private Label tricks;

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
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'myTricks.fxml'.";
        assert tricks != null : "fx:id=\"tricks\" was not injected: check your FXML file 'myTricks.fxml'.";
        UserSQL userSQL = UserSQL.getInstance();
        LocalDate date_current = LocalDate.now();
        ArrayList<String> list = userSQL.listAppointments(ToComeUser.getLogin(),date_current);
        String str = "";
        for (int i = 0; i < list.size();i++){
            str+=list.get(i)+"\n";
        }
        tricks.setText(str);
    }

}
