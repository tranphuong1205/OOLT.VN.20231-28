package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import tree.BNode;
import tree.BSTree;
import tree.GenericNode;

public class BSTPane extends Pane {
    private BSTree tree;
    private double radius = 15;
    private double vGap = 50;
    private BNode searchedNode;
    public  BSTPane(BSTree tree){
        this.tree = tree;
        setBackground(new Background(new BackgroundFill(Color.web("#444444"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public  void displayTree(){
        this.getChildren().clear();
        if(tree.getRoot() != null){
            displayTree(tree.getRoot(),getWidth() / 2, vGap, getWidth() / 4, Color.MEDIUMPURPLE );
        }}

        private void displayTree(BNode root, double x, double y, double hGap, Color color){
            if(root.getLeft() != null){
                getChildren().add(new Line(x - hGap, y + vGap, x,y));
                displayTree(root.getLeft(), x - hGap, y + vGap, hGap/2, color);
            }
            if(root.getRight() != null){
                getChildren().add(new Line(x+ hGap, y + vGap, x,y));
                displayTree(root.getRight(), x+ hGap, y + vGap, hGap/2, color);
            }
            Circle circle = new Circle(x, y, radius);
            circle.setFill(root == searchedNode ? Color.RED : color);
            if(root.getVisited()){
                circle.setFill(Color.GREEN);
            }
            circle.setStroke(Color.BLACK);
            getChildren().addAll(circle, new Text(x - 4, y + 4, root.getNodeValue() + " "));


        }
    public void searchNode(BNode searchedNode) {
        this.searchedNode = searchedNode;
    }

    public void clearSearch() {
        this.searchedNode = null;
    }

    }
