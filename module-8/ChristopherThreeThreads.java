package ReaneyModule8ProgrammingAssignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import java.util.Random;

/**
*   Assignment: Module 8
*   Date: 04/18/2025
*   @author Christopher Reaney
* 
*   This class is used to demonstrate the use of multiple threads in Java. 
*       It uses three different threads, each outputting their own type of
*       character, and each in their own thread. One thread outputs letters,
*       another numbers, and the final thread outputs special characters. These
*       are all appended to a display.
*/
public class ChristopherThreeThreads extends Application{

    //  Number of characters per thread, using the provided 10,000 minimum
    private static final int COUNT = 10000; 
    
    //  Create a textbox that the characters can be pushed to
    private final TextArea textArea = new TextArea();
    
    //  Random object for the three threads to use
    private final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        textArea.setWrapText(true);
        textArea.setEditable(false);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Three Threads Text Box");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start all three threads
        new Thread(new LetterGenerator()).start();
        new Thread(new DigitGenerator()).start();
        new Thread(new SpecialGenerator()).start();
    }

    // Thread 1: Generates random lowercase letters
    class LetterGenerator implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char letter = (char) ('a' + random.nextInt(26));
                appendText(letter);
            }
        }
    }

    // Thread 2: Generates random digits
    class DigitGenerator implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char digit = (char) ('0' + random.nextInt(10));
                appendText(digit);
            }
        }
    }

    // Thread 3: Generates special characters
    class SpecialGenerator implements Runnable {
        private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*', '+'};

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char symbol = symbols[random.nextInt(symbols.length)];
                appendText(symbol);
            }
        }
    }

    // Safely append text to the TextArea from any of the threads
    private void appendText(char c) {
        Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
    }
}