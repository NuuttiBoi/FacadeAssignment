module org.example.facadeassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens org.example.facadeassignment to javafx.fxml;
    exports org.example.facadeassignment;
}