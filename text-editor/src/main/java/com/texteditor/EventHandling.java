package com.texteditor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class EventHandling {
    
    public static void saveFile(TextArea textArea) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                String text = textArea.getText();
                Files.write(Paths.get(file.getAbsolutePath()), text.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void openFile(TextArea textArea) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                textArea.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
