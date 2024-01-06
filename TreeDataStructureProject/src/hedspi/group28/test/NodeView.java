package hedspi.group28.test;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class NodeView {
    private Circle circle;
    private Label label;

    public NodeView(int data, double x, double y) {
        this.circle = new Circle(20);
        this.label = new Label(Integer.toString(data));

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(3);

        label.setFont(Font.font("Arial", 14));
        label.setTextFill(Color.BLACK);
        label.setStyle("-fx-font-weight: bold;");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setPrefWidth(40);
        label.setWrapText(true);

        setPosition(x, y);
    }

    public Circle getCircle() {
        return circle;
    }

    public Label getLabel() {
        return label;
    }

    public void setPosition(double x, double y) {
        circle.setCenterX(x);
        circle.setCenterY(y);
        label.setLayoutX(x - 6);
        label.setLayoutY(y - 6);
    }

    public void addToPane(Pane pane) {
        pane.getChildren().addAll(circle, label);
    }
}
