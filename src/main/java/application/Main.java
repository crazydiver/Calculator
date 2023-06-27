package application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage Stage) {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/application/Main.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
