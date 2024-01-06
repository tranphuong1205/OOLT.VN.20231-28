package hedspi.group28.test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import hedspi.group28.model.tree.BNode;

public class TreeController {
    public void drawTree(BNode node, Pane pane, double x, double y, int level) {
        if (node != null) {
            NodeView nodeView = new NodeView(node.getNodeValue(), x, y);
            nodeView.addToPane(pane);

            double xLeft = x - 100 / (level + 1);
            double xRight = x + 100 / (level + 1);
            double yNext = y + 50;

            if (node.getLeft() != null) {
                Line leftLine = new Line(x, y + 20, xLeft, yNext);
                pane.getChildren().add(leftLine);
                drawTree(node.getLeft(), pane, xLeft, yNext, level + 1);
            }
            if (node.getRight() != null) {
                Line rightLine = new Line(x, y + 20, xRight, yNext);
                pane.getChildren().add(rightLine);
                drawTree(node.getRight(), pane, xRight, yNext, level + 1);
            }
        }
    }
}

