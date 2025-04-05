package org.example.test_hw2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Menu {

    @FXML
    private AnchorPane anchorPane;

    // This method is called by the FXMLLoader when initialization is complete
    @FXML
    public void initialize() {
        System.out.println("Menu controller initialized.");
        // You can add logic here to be executed when the UI is loaded
    }
    @FXML
    private void click_shod(ActionEvent event) {
        System.out.println("khorde.");

    }

    public void best_record_clicked(ActionEvent actionEvent) {
    }

    public void history_clicked(ActionEvent actionEvent) {
    }

    public void setting_clicked(ActionEvent actionEvent) {
    }

    public void exit_clicked(ActionEvent actionEvent) {
    }
}
