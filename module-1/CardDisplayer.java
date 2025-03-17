package ReaneyModule1ProgrammingAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
*  Assignment: Module 1
*  Date: 03/17/2025
*  @author Christopher Reaney
* 
*  This class is used to display four images at random from a deck of
*      52 different cards. 
*/
public class CardDisplayer extends Application {
    
    //  Initialize an ArrayList to store numbers for each of the cards
    private ArrayList<Integer> cardNumbers = new ArrayList<>();
    
    //  Fill the card list in with numbers up to 52 (number of images)
    Integer counter = 1;
    
    //  Keeps track of how many cycles of cards the user has seen.
    Integer clickCounter = 1;
    
    //  Create a VBOX element that will be used to display the card images
    private VBox vBox = new VBox(5);
   
    //Create a method to "start" - needs to be override
    @Override
    public void start(Stage stage) throws Exception 
    {  
        //  Add an integer to track each of the 52 cards to an array.
        while(counter <= 52)
        {
            cardNumbers.add(counter);
            counter += 1;
        }
            
        //  Create a button to use for displaying/resetting the selection of cards
        Button button = new Button("Get 4 Random Cards");
        
        Label label = new Label(); // create label
        
        //  Give the button the job of getting cards and displaying them 
        button.setOnAction(event -> getCardsForDisplaying());

        // Create a pane to hold the vBox, label and the button       
        button.setLayoutY(400);
        button.setLayoutX(5);
        label.setLayoutY(425);
        label.setLayoutX(5);
        Pane root = new Pane();
        root.getChildren().add(button);
        root.getChildren().add(label);
        root.getChildren().add(vBox);

        //  Lastly, create a scene and put on stage
        Scene scene = new Scene(root, 270, 450);
        stage.setTitle("Is this your card?");
        stage.setScene(scene);
        
        //  Show the stage
        stage.show();
    }
    
    /**
     *  This method is used for obtaining the card images that will be displayed.
     */
    private void getCardsForDisplaying() {
        
        //  Reset counter to use when this method resets
        counter = 0;
        
        //  Clear out the previous selection of cards (if any)
        vBox.getChildren().clear();
        
        //  Pick four cards at random to display (shuffle the list order)
        Collections.shuffle(cardNumbers);       
        
        while(counter < 4){
            
            InputStream stream = null;
            
            //  Get the filepath of the card
            String cardPath = "cards/" + cardNumbers.get(counter) + ".png";
            
            //  Try to get image at path. If it fails, exit the program and print an error
            try{
                stream = new FileInputStream(cardPath);
            }
            catch(FileNotFoundException e){
                System.out.println("No images found in directory 'cards/'");
                System.exit(2);
            }
            
            //  Add the image that was just pulled
            Image img = new Image(stream);
            vBox.getChildren().add(new ImageView(img));
                    
            //  Move on to next iteration
            counter++;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
