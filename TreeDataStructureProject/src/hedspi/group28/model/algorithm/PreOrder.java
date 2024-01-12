package hedspi.group28.model.algorithm;

import java.util.LinkedList;

import hedspi.group28.model.tree.BNode;
import hedspi.group28.model.tree.GenericNode;

public class PreOrder implements Algorithm {
	private LinkedList<Integer> traversalList = new LinkedList<>();
	
	public void traverse(BNode root) {
		if(root == null) {
			return;}
		traversalList.add(root.getNodeValue());
		traverse(root.getLeft());
		traverse(root.getRight());
	}
	
	public void traverse( GenericNode node) {
		 if(node == null) return ;
		 traversalList.add(node.getNodeValue());
		 GenericNode p = node.getLeftMostChild();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
	 }
	
	public LinkedList<Integer> getTraversalList() {
	    return traversalList;
	}
}
