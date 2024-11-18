module com.example.cs213project4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.example.cs213project4 to javafx.fxml;
    exports com.example.cs213project4;
}