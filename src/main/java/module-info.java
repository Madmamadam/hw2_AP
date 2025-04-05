module org.example.test_hw2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.test_hw2 to javafx.fxml;
    exports org.example.test_hw2;
}