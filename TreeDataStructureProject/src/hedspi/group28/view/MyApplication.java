package hedspi.group28.view;

import hedspi.group28.controller.StartSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
public class MyApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/StartScene.fxml"));
        loader.setController(new StartSceneController());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scene 1");

        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Ngăn không đóng cửa sổ ngay lập tức
            exitApplication(primaryStage); // Gọi hàm xác nhận thoát khi đóng cửa sổ
        });

        primaryStage.show();
    }

    public void exitApplication(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(javafx.scene.control.ButtonType.YES, javafx.scene.control.ButtonType.CANCEL);
        alert.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.YES) {
                primaryStage.close();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
