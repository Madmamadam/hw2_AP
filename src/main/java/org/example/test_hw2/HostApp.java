package org.example.test_hw2;

//import org.example.test_hw2.HelloApplication;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class HostApp {
    public void main(String[] args) {
        // Your host code might do other work here
        System.out.println("Host application running. Press ENTER to start the game...");

        try {
            System.in.read();  // Wait for user input
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaPlayer mediaPlayer;
        String musicFile = getClass().getResource("/roa-music-city-lights.mp3").toExternalForm();
        Media sound = new Media(musicFile);
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop indefinitely
        mediaPlayer.play();

        // Call the game module. Application.launch is blocking, so this call will run
        // and block until the game window is closed.
        HelloApplication.main(args);

        // Optionally, after the game ends, continue with host code.
        System.out.println("Game has exited. Returning to host application logic.");
    }
}