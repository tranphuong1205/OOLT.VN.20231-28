package hedspi.group28.test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Stack;

public class SceneHistoryExample extends Application {
    private Stack<Scene> sceneHistory = new Stack<>();

    @Override
    public void start(Stage primaryStage) {
        // Scene 1
        Button button1 = new Button("Go to Scene 2");
        button1.setOnAction(e -> goToScene2(primaryStage));

        StackPane layout1 = new StackPane();
        layout1.getChildren().add(button1);
        Scene scene1 = new Scene(layout1, 300, 200);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene 1");
        primaryStage.show();

        // Push the initial scene to history
        sceneHistory.push(scene1);
    }

    private void goToScene2(Stage primaryStage) {
        // Scene 2
        Button button2 = new Button("Go back to Scene 1");
        button2.setOnAction(e -> goBack(primaryStage));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        Scene scene2 = new Scene(layout2, 300, 200);

        // Store the current scene in history before changing
        sceneHistory.push(primaryStage.getScene());

        primaryStage.setScene(scene2);
        primaryStage.setTitle("Scene 2");
        primaryStage.show();
    }

    private void goBack(Stage primaryStage) {
        if (!sceneHistory.isEmpty()) {
            Scene previousScene = sceneHistory.pop();
            primaryStage.setScene(previousScene);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
