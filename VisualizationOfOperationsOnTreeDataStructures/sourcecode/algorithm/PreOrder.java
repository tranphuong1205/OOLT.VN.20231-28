package algorithm;
import gui.BSTPane;
import javafx.scene.layout.Pane;
import tree.GenericNode;
import tree.BNode;
public class PreOrder implements Algorithm {
	public void traverse(BNode root) {
		if(root == null) {
			return;}
		System.out.print(root.getNodeValue() + "-> ");
		traverse(root.getLeft());
		traverse(root.getRight());
	}
	public void traverse( GenericNode node) {
		 if(node == null) return ;
		 System.out.print(node.getNodeValue() + " ");
		 GenericNode p = node.getLeftMostChild();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
	 }
	 public void uiTraverse(BNode node, BSTPane pane){}
	
}
