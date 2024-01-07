package gui;

import algorithm.Algorithm;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tree.BNode;
import tree.BSTree;
import tree.GenericNode;

import java.util.ArrayList;



public class BSTPane extends Pane {
    private BSTree tree;
    private double radius = 15;
    private double vGap = 50;
    private BNode searchedNode;

    private Algorithm algorithm;

    public BSTPane(BSTree tree) {
        this.tree = tree;
        setBackground(new Background(new BackgroundFill(Color.web("#444444"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void displayTree() {
        this.getChildren().clear();
        if (tree.getRoot() != null) {
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4, Color.MEDIUMPURPLE);
        }
    }

    private void displayTree(BNode root, double x, double y, double hGap, Color color) {
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


        circle.setStroke(Color.BLACK);
        Group group = new Group();
        group.getChildren().addAll(circle, new Text(x - 4, y + 4, root.getNodeValue() + " "));
        getChildren().add(group);

    }

    public void searchNode(BNode searchedNode) {
        this.searchedNode = searchedNode;
    }

    public void clearSearch() {
        this.searchedNode = null;
    }

    public void setAlgorithm(Algorithm a){
        this.algorithm = a;
    }



    /* HBox findNode(int key){
       ObservableList<Node> nodes = BSTPane.getChildren();
       for(Node node : nodes){
           if(node instanceof  AnchorPane anchorPane)
               continue;
           ObservableList<Node> children = anchorPane.getChildren();
           for(Node child : children){
               if(!(child instanceof  HBox hBox))
                   continue;
               ObservableList<Node> hBoxChildren = hBox.getChildren();
               for(Node hBoxChild : hBoxChildren){
                   if(hBoxChild instanceof Label label && label.getText().equals(String.valueOf(key)))
                       return hBox;
               }
           }

       }
       return null;
    }


   /* public void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }*/
}
