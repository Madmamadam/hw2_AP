package org.example.test_hw2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuApp extends Application {

    private Scene mainMenuScene;
    private Scene newGameScene;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Create main menu pane
        VBox mainMenuPane = createMainMenuPane();
        mainMenuScene = new Scene(mainMenuPane, 300, 400);

        // Set up stage
        primaryStage.setTitle("Menu");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    private VBox createMainMenuPane() {
        // Create label for game name
        Label gameNameLabel = new Label("Super Hexagon");
        gameNameLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-font-weight: bold;");

        // Create label for total record
        Label totalRecordLabel = new Label("Total Record: 100");  // Edit this text as needed
        totalRecordLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");

        // Create buttons
        Button newGameButton = new Button("New Game");
        Button historyButton = new Button("History");
        Button settingsButton = new Button("Settings");
        Button exitButton = new Button("Exit");

        // Define styles for buttons
        String buttonStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; " +
                "-fx-padding: 10 20; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";
        String buttonHoverStyle = "-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-size: 14px; " +
                "-fx-padding: 10 20; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";

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

        // Set button actions
        newGameButton.setOnAction(e -> {
            // Create new game pane
            VBox newGamePane = createNewGamePane();
            newGameScene = new Scene(newGamePane, 300, 400);
            primaryStage.setScene(newGameScene);
        });
        historyButton.setOnAction(e -> System.out.println("Opening history..."));
        settingsButton.setOnAction(e -> System.out.println("Opening settings..."));
        exitButton.setOnAction(e -> primaryStage.close());

        // Create layout with background color
        VBox menuLayout = new VBox(20);  // Spacing between elements
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(30));
        menuLayout.setStyle("-fx-background-color: #212121;");  // Dark background
        menuLayout.getChildren().addAll(gameNameLabel, totalRecordLabel, newGameButton, historyButton, settingsButton, exitButton);

        // Add extra space below the game name and total record labels
        VBox.setMargin(gameNameLabel, new Insets(0, 0, 10, 0));  // 10px bottom margin
        VBox.setMargin(totalRecordLabel, new Insets(0, 0, 20, 0));  // 20px bottom margin

        return menuLayout;
    }

    private VBox createNewGamePane() {
        // Create label for instruction
        Label nameLabel = new Label("Enter Your Name:");
        nameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");

        // Create text field for name input
        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-color: #424242; -fx-text-fill: white; -fx-font-size: 14px; " +
                "-fx-padding: 10; -fx-background-radius: 5;");
        nameField.setMaxWidth(200);

        // Create start button
        Button startButton = new Button("Start");
        startButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; " +
                "-fx-padding: 10 20; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);");
        startButton.setOnMouseEntered(e -> startButton.setStyle(
                "-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-size: 14px; " +
                        "-fx-padding: 10 20; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);"));
        startButton.setOnMouseExited(e -> startButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; " +
                        "-fx-padding: 10 20; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);"));
        startButton.setOnAction(e -> {
            String playerName = nameField.getText();
            System.out.println("Starting game for player: " + (playerName.isEmpty() ? "Unknown" : playerName));
            // Add your game start logic here
        });

        // Create back button
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 14px; " +
                "-fx-padding: 10 20; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);");
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-background-color: #EF5350; -fx-text-fill: white; -fx-font-size: 14px; " +
                        "-fx-padding: 10 20; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);"));
        backButton.setOnMouseExited(e -> backButton.setStyle(
                "-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 14px; " +
                        "-fx-padding: 10 20; -fx-background-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);"));
        backButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        // Create layout for new game pane
        VBox newGameLayout = new VBox(20);
        newGameLayout.setAlignment(Pos.CENTER);
        newGameLayout.setPadding(new Insets(30));
        newGameLayout.setStyle("-fx-background-color: #212121;");  // Dark background
        newGameLayout.getChildren().addAll(nameLabel, nameField, startButton, backButton);

        // Add spacing
        VBox.setMargin(nameLabel, new Insets(0, 0, 10, 0));
        VBox.setMargin(nameField, new Insets(0, 0, 20, 0));

        return newGameLayout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}