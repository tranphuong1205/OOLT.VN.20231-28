package algorithm;

import gui.BSTPane;
import javafx.scene.layout.Pane;
import tree.GenericNode;
import tree.BNode;
import java.util.LinkedList;
import java.util.Queue;

 public class LevelOrder implements Algorithm{
	 public void traverse(BNode root) {
		 Queue<BNode> nodeList = new LinkedList<BNode>();
			nodeList.add(root);
			while(!nodeList.isEmpty()) {
				BNode temp = nodeList.poll();
				System.out.print(temp.getNodeValue()+ " -> ");
				if(temp.getLeft() != null) {
					nodeList.add(temp.getLeft());
				}
				if(temp.getRight() != null) {
					nodeList.add(temp.getRight());
				}
			}
	 }
public void traverse( GenericNode node) {
		 if(node == null) return ;
		 Queue<GenericNode> queue = new LinkedList<GenericNode>();
		 queue.offer(node);
		 while(!queue.isEmpty()) {
			 GenericNode p = queue.poll();
			 System.out.print(p.getNodeValue() + " ");
			 GenericNode q = p.getLeftMostChild();
			 while( q != null) {
				 queue.offer(q);
				 q = q.getRightSibling();
			 }
		 }
		 
	 }
	 public void uiTraverse(BNode node, BSTPane pane){}
}
