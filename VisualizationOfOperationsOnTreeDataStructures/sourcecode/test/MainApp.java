package test;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/controller/Visualization.fxml")));
            primaryStage.setTitle("Trees");
            primaryStage.setScene(new Scene(root, 410, 340));
        }
        catch (NullPointerException e){
            e.getMessage();
        }
        primaryStage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "This is a data-tree visualization", ButtonType.OK);
        alert.getDialogPane().setMinHeight(80);
        alert.show();

    }

}
