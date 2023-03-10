package com.frauas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1280, 720);
        scene.getStylesheets().add(App.class.getResource("style/primary.css").toExternalForm());
        stage.getIcons().add(new Image(App.class.getResource("img/OFC.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

    public static void setStyle(String css) {
        scene.getStylesheets().add(App.class.getResource(css + ".css").toExternalForm());
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}