package hedspi.group28.model.algorithm;

import hedspi.group28.model.tree.BNode;
import hedspi.group28.model.tree.GenericNode;
import java.util.LinkedList;


public  class InOrder implements Algorithm{
	 private LinkedList<Integer> traversalList = new LinkedList<>();
	 
	 public void traverse(BNode root) {
		 if(root == null) {
				return;}
		 traverseWithDelay(root);
	 }
	 private void traverseWithDelay(BNode node) {
		 if (node != null) {
			 traversalList.add(node.getNodeValue());
			 node.setVisited(true);
			 traverse(node.getRight());
		 }
	 }
	 	 
	 public void traverse( GenericNode node) {
		 if(node == null) return ;
		 GenericNode p = node.getLeftMostChild();
		 traversalList.add(node.getNodeValue());
		 traverse(p);
		 if(p != null)
			 p = p.getRightSibling();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
	 }
	 
	 public LinkedList<Integer> getTraversalList() {
	        return traversalList;
    }
}
