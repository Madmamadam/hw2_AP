module org.example.test_hw2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
//    requires javafx.media;


    opens org.example.test_hw2 to javafx.fxml;
    exports org.example.test_hw2;
}