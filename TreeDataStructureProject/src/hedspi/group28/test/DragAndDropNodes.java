package hedspi.group28.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DragAndDropNodes extends Application {
    private static final int NODE_RADIUS = 20;
    private Circle selectedNode;
    private double offsetX, offsetY;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Pane pane = new Pane(root);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Drag and Drop Nodes");
        primaryStage.setScene(scene);
        primaryStage.show();

        Circle node = createNode(100, 100);
        Circle node2 = createNode(200, 200);

        pane.getChildren().addAll(node, node2);

        node.setOnMousePressed(this::onNodePressed);
        node.setOnMouseDragged(this::onNodeDragged);

        node2.setOnMousePressed(this::onNodePressed);
        node2.setOnMouseDragged(this::onNodeDragged);
    }

    private Circle createNode(double x, double y) {
        Circle circle = new Circle(x, y, NODE_RADIUS);
        Label label = new Label("Node");
        label.setLayoutX(x - 15);
        label.setLayoutY(y - 10);

        return circle;
    }

    private void onNodePressed(MouseEvent event) {
        selectedNode = (Circle) event.getSource();
        offsetX = event.getSceneX() - selectedNode.getCenterX();
        offsetY = event.getSceneY() - selectedNode.getCenterY();
    }

    private void onNodeDragged(MouseEvent event) {
        if (selectedNode != null) {
            double newX = event.getSceneX() - offsetX;
            double newY = event.getSceneY() - offsetY;

            selectedNode.setCenterX(newX);
            selectedNode.setCenterY(newY);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
