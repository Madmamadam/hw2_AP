package org.example.test_hw2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.File;
import java.text.DecimalFormat;

import static org.example.test_hw2.filee.plays;

//import javafx.scene.media.Media;


public class HostApp extends Application {
    private boolean isPlaying = true;
    private boolean save = true;
    private MediaPlayer mediaPlayer;


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {

        filee.read();


        //---------------------------------------------------------------------------
        //----------------------------------------------------------------------music
        //---------------------------------------------------------------------------
        Media sound = new Media(new File("src/main/resources/roa-music-city-lights.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        //---------------------------------------------------------------------------
        //----------------------------------------------------------------------music
        //---------------------------------------------------------------------------



        //---------------------------------------------------------------------------
        //-----------------------------------------------------------------menulayout
        //---------------------------------------------------------------------------

        // Define styles for buttons
        String buttonStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";
        String offbuttonStyle = "-fx-background-color: #af1818; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";

        String buttonHoverStyle = "-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";
        String buttonoffHoverStyle = "-fx-background-color: #c63636; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 0, 2);";

        String textStyle = "-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold";


        // Create label for game name
        Label gameNameLabel = new Label("Super Hexagon");
        gameNameLabel.setStyle(textStyle);

        // Create label for total record
        double maxscore=0.0;
        for(Play play : plays) {
            if(maxscore<play.score){maxscore=play.score;}
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(java.math.RoundingMode.FLOOR); // قطع کردن به جای گرد کردن
        String formattedScore = df.format(maxscore);
        Label totalRecordLabel = new Label("Total Record :"+formattedScore);  // Edit this text as needed
        totalRecordLabel.setStyle(textStyle);


        // Create buttons
        Button newGameButton = new Button("New Game");
        Button historyButton = new Button("History");
        Button settingsButton = new Button("Settings");
        Button exitButton = new Button("Exit");

        Button startButton = new Button("Start");

        Button musicButton = new Button("Music");
        Button saveButton = new Button("save in history");
        Button backButton = new Button("Back");



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

        startButton.setStyle(buttonStyle);
        startButton.setOnMouseEntered(e -> startButton.setStyle(buttonHoverStyle));
        startButton.setOnMouseExited(e -> startButton.setStyle(buttonStyle));

        musicButton.setStyle(buttonStyle);
        musicButton.setOnMouseEntered(e -> {
            if(isPlaying)
                musicButton.setStyle(buttonHoverStyle);
            else
                musicButton.setStyle(buttonoffHoverStyle);
        });
        musicButton.setOnMouseExited(e -> {
            if(isPlaying)
                musicButton.setStyle(buttonStyle);
            else
                musicButton.setStyle(offbuttonStyle);
        });

        saveButton.setStyle(buttonStyle);
        saveButton.setOnMouseEntered(e -> {
            if(save)
                saveButton.setStyle(buttonHoverStyle);
            else
                saveButton.setStyle(buttonoffHoverStyle);
        });
        saveButton.setOnMouseExited(e ->{
            if(save)
                saveButton.setStyle(buttonStyle);
            else
                saveButton.setStyle(offbuttonStyle);
        });

        backButton.setStyle(buttonStyle);
        backButton.setOnMouseEntered(e -> backButton.setStyle(buttonHoverStyle));
        backButton.setOnMouseExited(e -> backButton.setStyle(buttonStyle));



        // Create layout with background color
        VBox menuLayout = new VBox(20);  // Spacing between elements
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(30));
        menuLayout.setStyle("-fx-background-color: #212121;");  // Dark background
        menuLayout.getChildren().addAll(gameNameLabel, totalRecordLabel, newGameButton, historyButton, settingsButton, exitButton);

        Scene menuscene = new Scene(menuLayout);
        primaryStage.setScene(menuscene);
        primaryStage.show();
        double height=menuLayout.getHeight();
        double width=menuLayout.getWidth();

        //start sub menu

        Label nameLabel = new Label("Enter Your Name:");
        nameLabel.setStyle(textStyle);

        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-color: #424242; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10; -fx-background-radius: 5;");
        nameField.setMaxWidth(200);



        VBox substartLayout = new VBox(20);
        substartLayout.setAlignment(Pos.CENTER);
        substartLayout.setPadding(new Insets(30));
        substartLayout.setStyle("-fx-background-color: #212121;");
        substartLayout.getChildren().addAll(nameLabel,nameField,startButton);
        Scene startmenuscene = new Scene(substartLayout);

        //setting sub menu
        Label nameLabel2 = new Label("Setting");
        nameLabel2.setStyle(textStyle);







        VBox subsettingLayout = new VBox(20);
        subsettingLayout.setAlignment(Pos.CENTER);
        subsettingLayout.setPadding(new Insets(30));
        subsettingLayout.setStyle("-fx-background-color: #212121;");
        subsettingLayout.getChildren().addAll(nameLabel2,musicButton,saveButton,backButton);

        Scene submenuscene = new Scene(subsettingLayout);



        //historysubmenu
        VBox subhisLayout = new VBox(20);
        subhisLayout.setAlignment(Pos.CENTER);
        subhisLayout.setPadding(new Insets(30));
        subhisLayout.setStyle( "-fx-font-size: 14;" +
                "-fx-fill: #ff0000;" +
                "-fx-padding: 5;" +
                "-fx-background-color: #212121;" +
                "-fx-background-radius: 5;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 2, 0, 0, 1);");

        // Create a ScrollPane and add the VBox to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(subhisLayout);
        scrollPane.setStyle(
                "-fx-background: #e8ecef;" + "-fx-border-color: #d0d0d0;" + "-fx-border-width: 1;");
        scrollPane.setFitToWidth(true); // Make content fit the width of the ScrollPane
        scrollPane.setPrefSize(width, height);

        Scene hismenuscene = new Scene(scrollPane);








        //---------------------------------------------------------------------------
        //-----------------------------------------------------------------menulayout
        //---------------------------------------------------------------------------



        primaryStage.setOnHidden(event -> {
            Platform.runLater(() -> {
                primaryStage.setScene(menuscene);
                primaryStage.show();
            });
        });

        newGameButton.setOnAction(event -> {
            primaryStage.setScene(startmenuscene);
        });
        startButton.setOnAction(event -> {
            if(nameField.getText().length()!=0) {
                Play play = new Play(nameField.getText());
                HelloApplication.staart(primaryStage,play,save);

            }
        });
        historyButton.setOnAction(event ->{
            for (Play play : plays){
                Text text = new Text("user: "+play.username+"\nscore: "+play.score+"\nDate:"+play.date);
                text.setStyle("-fx-font-size: 11px; -fx-fill: #4CAF50; -fx-font-weight: bold");
                subhisLayout.getChildren().add(text);
            }
            primaryStage.setScene(hismenuscene);
        });
        settingsButton.setOnAction(event -> {
            primaryStage.setScene(submenuscene);

        });

        musicButton.setOnAction(event -> {
            isPlaying = !isPlaying;
            if (isPlaying) {
                mediaPlayer.play();
                musicButton.setStyle(buttonStyle);
            } else {
                mediaPlayer.pause();
                musicButton.setStyle(offbuttonStyle);

            }
        });
        saveButton.setOnAction(event -> {
            if (!save) {
                save= true;
                saveButton.setStyle(buttonStyle);
            } else {
                save = false;
                saveButton.setStyle(offbuttonStyle);

            }

        });

        backButton.setOnAction(event ->{
            primaryStage.setScene(menuscene);
        } );





        exitButton.setOnAction(e -> {
            filee.save();
            System.exit(0);
        });
        primaryStage.setOnCloseRequest(e ->{
            filee.save();
            System.exit(0);
        });;




    }
}
