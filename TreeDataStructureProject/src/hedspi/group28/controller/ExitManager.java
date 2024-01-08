package hedspi.group28.controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class ExitManager {

    public static void setExitHandler(Stage stage) {
        stage.setOnCloseRequest(event -> {
            event.consume(); // Ngăn không đóng cửa sổ ngay lập tức
            confirmExit(stage); // Xác nhận khi đóng cửa sổ
        });
    }

    private static void confirmExit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            Platform.exit(); // Thoát ứng dụng khi xác nhận
        }
    }
}
