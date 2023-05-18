package com.texteditor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {

    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        // the root layout
        BorderPane root = new BorderPane();

        // Create a TextArea object to edit or add text
        textArea = new TextArea();
        root.setCenter(textArea);

        // Create buttons objects
        Button saveButton = new Button("Save");
        Button openButton = new Button("Open");

        // Add button event handlers
        saveButton.setOnAction(event -> EventHandling.saveFile(textArea));
        openButton.setOnAction(event -> EventHandling.openFile(textArea));

        //HBox to hold the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(saveButton, openButton);
        root.setBottom(buttonBox);
        buttonBox.setAlignment(Pos.CENTER);
        // Create the scene
        Scene scene = new Scene(root, 800, 600);

        // Set the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Editor");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
