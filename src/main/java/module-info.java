module com.pplabretake2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pplabretake2 to javafx.fxml;
    exports com.pplabretake2;
}