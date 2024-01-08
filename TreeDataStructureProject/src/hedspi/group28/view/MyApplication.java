package hedspi.group28.view;

import hedspi.group28.controller.ExitManager;
import hedspi.group28.controller.StartSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/StartScene.fxml"));
        loader.setController(new StartSceneController());
        Parent root = loader.load();
        primaryStage.setTitle("Visualization of operations on tree data structures");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ExitManager.setExitHandler(primaryStage); // Xác nhận thoát cho cửa sổ chính
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
