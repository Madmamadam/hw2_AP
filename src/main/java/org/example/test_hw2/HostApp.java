package org.example.test_hw2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

//import javafx.scene.media.Media;



import java.io.IOException;

public class HostApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        //---------------------------------------------------------------------------
        //-----------------------------------------------------------------menulayout
        //---------------------------------------------------------------------------

        // Define styles for buttons
        String buttonStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";
        String buttonHoverStyle = "-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";
        String textStyle = "-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold";


        // Create label for game name
        Label gameNameLabel = new Label("Super Hexagon");
        gameNameLabel.setStyle(textStyle);

        // Create label for total record
        Label totalRecordLabel = new Label("Total Record: 100");  // Edit this text as needed
        totalRecordLabel.setStyle(textStyle);


        // Create buttons
        Button newGameButton = new Button("New Game");
        Button historyButton = new Button("History");
        Button settingsButton = new Button("Settings");
        Button exitButton = new Button("Exit");

        // Apply styles to buttons
        newGameButton.setStyle(buttonStyle);
        newGameButton.setOnMouseEntered(e -> newGameButton.setStyle(buttonHoverStyle));
        newGameButton.setOnMouseExited(e -> newGameButton.setStyle(buttonStyle));

        historyButton.setStyle(buttonStyle);
        historyButton.setOnMouseEntered(e -> historyButton.setStyle(buttonHoverStyle));
        historyButton.setOnMouseExited(e -> historyButton.setStyle(buttonStyle));

        settingsButton.setStyle(buttonStyle);
        settingsButton.setOnMouseEntered(e -> settingsButton.setStyle(buttonHoverStyle));
        settingsButton.setOnMouseExited(e -> settingsButton.setStyle(buttonStyle));

        exitButton.setStyle(buttonStyle);
        exitButton.setOnMouseEntered(e -> exitButton.setStyle(buttonHoverStyle));
        exitButton.setOnMouseExited(e -> exitButton.setStyle(buttonStyle));

        // Create layout with background color
        VBox menuLayout = new VBox(20);  // Spacing between elements
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(30));
        menuLayout.setStyle("-fx-background-color: #212121;");  // Dark background
        menuLayout.getChildren().addAll(gameNameLabel, totalRecordLabel, newGameButton, historyButton, settingsButton, exitButton);

        Scene menuscene = new Scene(menuLayout);
        primaryStage.setScene(menuscene);
        primaryStage.show();

        //sub menu

        Label nameLabel = new Label("Enter Your Name:");
        nameLabel.setStyle(textStyle);

        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-color: #424242; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10; -fx-background-radius: 5;");
        nameField.setMaxWidth(200);

        Button startButton = new Button("Start");
        startButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; " +
                "-fx-padding: 10 20; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);");
        VBox startButtonLayout = new VBox(20);
        startButtonLayout.setAlignment(Pos.CENTER);


        startButtonLayout.setPadding(new Insets(30));
        startButtonLayout.setStyle("-fx-background-color: #212121;");
        startButtonLayout.getChildren().addAll(startButton, nameField,nameLabel);

        Scene startmenuscene = new Scene(startButton);





        //---------------------------------------------------------------------------
        //-----------------------------------------------------------------menulayout
        //---------------------------------------------------------------------------

        primaryStage.setOnHidden(event -> {
            Platform.runLater(() -> {
                System.out.println("hellloworld");
                primaryStage.setScene(menuscene);
                primaryStage.show();
                System.out.println("hellloworld");
            });
        });

        newGameButton.setOnAction(event -> {
            primaryStage.setScene(startmenuscene);
//            HelloApplication.staart(primaryStage);
        });
        exitButton.setOnAction(e -> System.exit(0));

    }
}
//        HelloApplication.staart(primaryStage);
//        primaryStage.setOnHidden(event -> System.out.println("Hello World!"));
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));


//    }
//    static void gogame(){
//        HelloApplication.staart(primaryStage);
//    }


//}