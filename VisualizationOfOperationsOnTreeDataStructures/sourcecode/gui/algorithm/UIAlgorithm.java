package gui.algorithm;

import gui.AVLPane;
import gui.BSTPane;
import gui.BTPane;
import tree.BNode;

public interface UIAlgorithm {
    public void traverse(BNode r, BTPane pane);
    public void traverse(BNode r, BSTPane pane);
    public void traverse(BNode r, AVLPane pane);

}
