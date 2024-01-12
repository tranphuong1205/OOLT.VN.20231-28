package hedspi.group28.model.algorithm;

import java.util.LinkedList;

import hedspi.group28.model.tree.BNode;
import hedspi.group28.model.tree.GenericNode;

public class PostOrder implements Algorithm {
    private LinkedList<Integer> traversalList = new LinkedList<>();

    public void traverse(GenericNode node) {
        if (node == null) return;       
        GenericNode p = node.getLeftMostChild();      
        while (p != null) {
            traverse(p);
            p = p.getRightSibling();
        }
        traversalList.add(node.getNodeValue());
    }

    public void traverse(BNode root) {
        if (root == null) {
            return;
        }
        traverse(root.getLeft());
        traverse(root.getRight());
        traversalList.add(root.getNodeValue());
    }

    public LinkedList<Integer> getTraversalList() {
        return traversalList;
    }
}
