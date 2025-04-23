package ReaneyModule7ProgrammingAssignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
*  Assignment: Module 7
*  Date: 04/22/2025
*  @author Christopher Reaney
* 
*  This class is used to display four circles in a window. This class uses JavaFX
*       along with an external CSS file to display the circles appropriately.
*/
public class CircleRama extends Application{

    @Override
    public void start(Stage primaryStage) {
        //  Create 4 circle objects
        Circle circle1 = new Circle(50);
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(50);
        Circle circle4 = new Circle(50);

        //  Apply style of both the CSS class
        //      and the CSS ID defined in styles.css
        circle1.getStyleClass().add("white-fill-black-stroke");
        circle2.getStyleClass().add("white-fill-black-stroke");
        circle3.setId("red-green-color");
        circle4.setId("red-green-color");

        //  Add circles to layout
        HBox hbox = new HBox(20, circle1, circle2, circle3, circle4);
        hbox.setStyle("-fx-padding: 20; -fx-background-color: lightgray;");

        //  Create scene and add in the CSS file
        Scene scene = new Scene(hbox);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());    

        primaryStage.setTitle("Stylish Circles using CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}