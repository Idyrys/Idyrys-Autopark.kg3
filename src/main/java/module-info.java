module com.example.renterproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.renterproject2 to javafx.fxml;
    exports com.example.renterproject2;
    exports com.example.renterproject2.controllers;
    opens com.example.renterproject2.controllers to javafx.fxml;
}