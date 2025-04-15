package org.example.test_hw2;

//import org.example.test_hw2.HelloApplication;

public class HostApp {
    public static void main(String[] args) {
        // Your host code might do other work here
        System.out.println("Host application running. Press ENTER to start the game...");

        try {
            System.in.read();  // Wait for user input
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Call the game module. Application.launch is blocking, so this call will run
        // and block until the game window is closed.
        HelloApplication.main(args);

        // Optionally, after the game ends, continue with host code.
        System.out.println("Game has exited. Returning to host application logic.");
    }
}