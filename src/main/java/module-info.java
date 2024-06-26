module com.example.vetclinik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.vetclinik to javafx.fxml;
    exports com.example.vetclinik;
}