package com.example.vetclinik;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private RadioButton btnAft;

    @FXML
    private RadioButton btnEven;

    @FXML
    private RadioButton btnMorn;

    @FXML
    private CheckBox clicker;

    @FXML
    private DatePicker date;

    @FXML
    private TextField name;

    @FXML
    private TextField namePoroda;
    @FXML
    private Label error;
    @FXML
    private ToggleGroup groupTime;

    @FXML
    private Button recording;
    private PetSQL petSQL;
    private AppointmentSQL appointmentSQL;
    public MakeAnAppointment(){
        petSQL = PetSQL.getInstance();
        appointmentSQL = AppointmentSQL.getInstance();
    }
    @FXML
    void clicker(MouseEvent event) {

    }

    @FXML
    void isPoroda(ActionEvent event) {
        namePoroda.setDisable(false);
    }
    @FXML
    void recording(MouseEvent event) {
        String status = "false";
        String poroda = "";
        if (!namePoroda.getText().isEmpty()){
            status = "true";
            poroda = namePoroda.getText();
        }
        String[] choice = new String[2];
        if (btnMorn.isSelected()){
            choice[0] = "10:00";
        }
        if (btnAft.isSelected()){
            choice[0] = "14:00";
        }
        if (btnEven.isSelected()){
            choice[0] = "17:00";
        }
        if (name.getText().isEmpty() & date.getValue()==null & choice[0] == null) {
            error.setText("не все поля заполнены");
        }
        else {
            //if (appointmentSQL.isOcupiedForUser(ToComeUser.getLogin(), date.getValue(), choice[0])) {

            boolean flag = petSQL.addPet(name.getText(), poroda, status, ToComeUser.getLogin());
            boolean f_add = false;
            if (flag) {
                f_add = appointmentSQL.addAppointment(name.getText(), date.getValue(), choice[0], ToComeUser.getLogin());
            }
            if (f_add) {
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
            else {
                error.setText("свободных докторов нет");
            }
//            }
//
//            else {
//                error.setText("вы уже записаны на прием в это время");
//            }


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
        assert btnAft != null : "fx:id=\"btnAft\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert btnEven != null : "fx:id=\"btnEven\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert btnMorn != null : "fx:id=\"btnMorn\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert clicker != null : "fx:id=\"clicker\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert namePoroda != null : "fx:id=\"namePoroda\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert recording != null : "fx:id=\"recording\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'makeAnAppointment.fxml'.";

        groupTime = new ToggleGroup();
        btnAft.setToggleGroup(groupTime);
        btnEven.setToggleGroup(groupTime);
        btnMorn.setToggleGroup(groupTime);

        namePoroda.setDisable(true);
    }
}
