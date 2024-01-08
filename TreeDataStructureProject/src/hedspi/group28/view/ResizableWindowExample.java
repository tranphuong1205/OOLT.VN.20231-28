package hedspi.group28.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ResizableWindowExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Resizable Window Example");

        Label label = new Label("Try resizing the window!");

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        // Bắt sự kiện thay đổi kích thước
        primaryStage.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            // Xử lý sự kiện thay đổi kích thước chiều rộng
            System.out.println("Width changed: " + newWidth);
        });

        primaryStage.heightProperty().addListener((obs, oldHeight, newHeight) -> {
            // Xử lý sự kiện thay đổi kích thước chiều cao
            System.out.println("Height changed: " + newHeight);
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
