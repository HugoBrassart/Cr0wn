module org.example.demo {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires java.sql;
    requires javafx.fxml;
    requires mysql.connector.j;


    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}