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
import tree.GenericNode;
import tree.GenericTree;


public class GenericPane extends Pane {
    private GenericTree tree;
    private double radius = 15;
    private double vGap = 50;

    private GenericNode searchedNode;

    public GenericPane(GenericTree tree) {
        this.tree = tree;
        setBackground(new Background(new BackgroundFill(Color.web("#444444"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void displayTree() {
        this.getChildren().clear();
        if (tree.getRoot() != null) {
            double temp = getWidth()/2;
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4,temp, Color.MEDIUMPURPLE);
        }
    }

    private void displayTree(GenericNode root, double x, double y, double hGap,double a, Color color) {
        if (root.getLeftMostChild() != null) {
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree(root.getLeftMostChild(), x - hGap, y + vGap, hGap / 2, a,color);}

        GenericNode h = root.getLeftMostChild();
        while (h != null &&  h.getRightSibling() != null) {
            getChildren().add(new Line(x - hGap/2, y + vGap, x,y));
             a = a + hGap/2;
            displayTree(h.getRightSibling(),a- hGap/2,y + vGap,hGap,a,color);
            h = h.getRightSibling();
        }


            Circle circle = new Circle(x, y, radius);
            circle.setFill(root == searchedNode ? Color.RED : color);
            circle.setStroke(Color.BLACK);
            getChildren().addAll(circle, new Text(x - 4, y + 4, root.getNodeValue() + " "));





    }



    public void searchNode(GenericNode searchedNode) {
        this.searchedNode = searchedNode;
    }

    public void clearSearch() {
        this.searchedNode = null;
    }
}
