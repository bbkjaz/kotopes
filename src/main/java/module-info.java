module com.example.vetclinik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vetclinik to javafx.fxml;
    exports com.example.vetclinik;
}