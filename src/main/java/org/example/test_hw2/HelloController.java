package org.example.test_hw2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Weeeeeeeeeeeeeeeeeeelcome to JavaFX Application!");
    }
}