package hedspi.group28.model.algorithm;

import hedspi.group28.model.tree.BNode;
import hedspi.group28.model.tree.GenericNode;
import java.util.LinkedList;

public  class InOrder implements Algorithm{
	 private LinkedList<Integer> traversalList = new LinkedList<>();
	 
	 public void traverse(BNode node) {
		    if (node != null) {
		        traverse(node.getLeft());
		        traversalList.add(node.getNodeValue());
		        traverse(node.getRight());
		    }
		}
	 	 
	 public void traverse(GenericNode node) {
		    if (node == null) return;

		    GenericNode p = node.getLeftMostChild();
		    while (p != null) {
		        traverse(p);
		        traversalList.add(node.getNodeValue());
		        p = p.getRightSibling();
		    }
		}
	 
	 public LinkedList<Integer> getTraversalList() {
	        return traversalList;
    }
}
