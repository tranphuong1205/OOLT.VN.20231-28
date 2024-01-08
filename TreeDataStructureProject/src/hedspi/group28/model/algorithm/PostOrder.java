package hedspi.group28.model.algorithm;

import hedspi.group28.model.tree.BNode;
import hedspi.group28.model.tree.GenericNode;

public class PostOrder implements Algorithm {
	public void traverse(BNode root) {
		if(root == null) {
			return;}
		traverse(root.getLeft());
		traverse(root.getRight());
		System.out.print(root.getNodeValue() + "-> ");
	}
	public void traverse( GenericNode node) {
		 if(node == null) return;
		 GenericNode p = node.getLeftMostChild();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
		 System.out.print(node.getNodeValue() + " ");
	 }
}
