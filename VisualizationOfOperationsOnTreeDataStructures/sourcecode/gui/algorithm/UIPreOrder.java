package gui.algorithm;

import gui.AVLPane;
import gui.BSTPane;
import gui.BTPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import tree.BNode;

public class UIPreOrder implements UIAlgorithm{
    public void traverse(BNode r, BTPane pane){
        if(r == null) return;
        r.setVisited(true);
        pane.displayTree();

        Timeline waitTimeline = new Timeline(new KeyFrame(
                Duration.seconds(2),
                event -> {
                    // Duyệt sang nút con trái
                    traverse(r.getLeft(), pane);
                    Timeline waitLeft = new Timeline(new KeyFrame(
                            Duration.seconds(3),
                            e -> {
                                // Duyệt sang nút phải
                                traverse(r.getRight(), pane);}));
                    waitLeft.play();
                }
        ));
        waitTimeline.play();
    }
    public void traverse(BNode r, BSTPane pane){
        if(r == null) return;
        r.setVisited(true);
        pane.displayTree();

        Timeline waitTimeline = new Timeline(new KeyFrame(
                Duration.seconds(2),
                event -> {
                    // Duyệt sang nút con trái
                    traverse(r.getLeft(), pane);
                    Timeline waitLeft = new Timeline(new KeyFrame(
                            Duration.seconds(3),
                            e -> {
                                // Duyệt sang nút phải
                                traverse(r.getRight(), pane);}));
                    waitLeft.play();
                }
        ));
        waitTimeline.play();
    }
    public void traverse(BNode r, AVLPane pane){
        if(r == null) return;
        r.setVisited(true);
        pane.displayTree();

        Timeline waitTimeline = new Timeline(new KeyFrame(
                Duration.seconds(2),
                event -> {
                    // Duyệt sang nút con trái
                    traverse(r.getLeft(), pane);
                    Timeline waitLeft = new Timeline(new KeyFrame(
                            Duration.seconds(3),
                            e -> {
                                // Duyệt sang nút phải
                                traverse(r.getRight(), pane);}));
                    waitLeft.play();
                }
        ));
        waitTimeline.play();
    }
}
