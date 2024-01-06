package gui;

import algorithm.Algorithm;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tree.AVLNode;
import tree.AVLTree;
import tree.BNode;
import tree.BSTree;

import static javax.swing.text.StyleConstants.setBackground;

public class AVLPane extends Pane {
    private AVLTree tree;
    private double vGap = 50;
    private double radius = 15;
    private AVLNode searchedNode;
    private Algorithm algorithm;

    public AVLPane(AVLTree tree) {
        this.tree = tree;
        setBackground(new Background(new BackgroundFill(Color.web("#444444"), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    public void displayTree(){
        this.getChildren().clear();
        if(tree.getRoot() != null) {
        displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4, Color.MEDIUMPURPLE);
    }}
    protected void displayTree(BNode root, double x, double y, double hGap, Color color) {
        if (root.getLeft() != null) {
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree(root.getLeft(), x - hGap, y + vGap, hGap / 2, color);
        }
        if (root.getRight() != null) {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree(root.getRight(), x + hGap, y + vGap, hGap / 2, color);
        }
        Circle circle = new Circle(x, y, radius);
        circle.setFill(root == searchedNode ? Color.RED : color);
        if (root.getVisited()) {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                circle.setFill(color);
                root.setVisited(false);
            });
            circle.setFill(Color.GREEN );
            pause.play();
        }

        if(algorithm != null){
            algorithm.traverse(root);

        }
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, root.getNodeValue() + " "));


    }

    public void searchNode(AVLNode searchedNode) {
        this.searchedNode = searchedNode;
    }

    public void clearSearch() {
        this.searchedNode = null;
    }

    public void setAlgorithm(Algorithm a){
        this.algorithm = a;
    }
}
