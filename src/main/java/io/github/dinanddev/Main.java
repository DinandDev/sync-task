package io.github.dinanddev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var resource = getClass().getResource("/view/MainView.fxml");

        if (resource == null) {
            throw new RuntimeException("Fatal Error: MainView.fxml not found in resources/view/");
        }

        FXMLLoader loader = new FXMLLoader(resource);
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("SyncTask");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}