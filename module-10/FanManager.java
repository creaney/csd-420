package ReaneyModule10ProgrammingAssignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

/**
 *
 *  @author: Christopher Reaney
 *  Assignment: Module 10 Programming Assignment
 *  Date: 05/04/2025
 *  This class is used to interact with an existing mysql table. It can be used
 *      to view or update existing records in that table by providing an ID. 
 */
public class FanManager extends Application {

    private TextField idField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField favoriteTeamField = new TextField();
    private Label statusLabel = new Label();

    private final String DB_URL = "jdbc:mysql://localhost/databasedb";
    private final String USER = "student1";
    private final String PASS = "pass";

    @Override
    public void start(Stage primaryStage) {
        //  Labels and fields
        VBox form = new VBox(10);
        form.setPadding(new Insets(15));

        form.getChildren().addAll(
            new Label("Enter ID (Needed for Display Function):"),
            idField,
            new Label("First Name:"),
            firstNameField,
            new Label("Last Name:"),
            lastNameField,
            new Label("Favorite Team:"),
            favoriteTeamField
        );

        //  Buttons
        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");

        displayButton.setOnAction(e -> displayFan());
        updateButton.setOnAction(e -> updateFan());

        //  Organize the buttons on the display
        HBox buttons = new HBox(10, displayButton, updateButton);
        form.getChildren().addAll(buttons, statusLabel);

        // Scene and Stage
        Scene scene = new Scene(form, 300, 350);
        primaryStage.setTitle("Fan Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayFan() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            statusLabel.setText("Please enter an ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            //  Parse whatever the use provided for an int
            stmt.setInt(1, Integer.parseInt(idText));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
                statusLabel.setText("Record displayed.");
            } else {
                statusLabel.setText("No record found for ID: " + idText);
            }

        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    private void updateFan() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(
                "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?")) {

            stmt.setString(1, firstNameField.getText().trim());
            stmt.setString(2, lastNameField.getText().trim());
            stmt.setString(3, favoriteTeamField.getText().trim());
            stmt.setInt(4, Integer.parseInt(idField.getText().trim()));

            int rowsUpdated = stmt.executeUpdate();
            statusLabel.setText(rowsUpdated > 0 ? "Record updated." : "No matching record found.");

        } catch (Exception e) {
            statusLabel.setText("Update failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}