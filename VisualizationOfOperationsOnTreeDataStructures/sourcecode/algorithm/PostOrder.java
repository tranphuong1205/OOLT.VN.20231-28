package algorithm;
import gui.BSTPane;
import javafx.scene.layout.Pane;
import tree.GenericNode;
import tree.BNode;
public class PostOrder implements Algorithm {
	public void traverse(BNode root) {
		if(root == null) {
			return;}
		traverse(root.getLeft());
		traverse(root.getRight());
		System.out.print(root.getNodeValue() + "-> ");
	}
	public void traverse( GenericNode node) {
		 if(node == null) return ;
		 GenericNode p = node.getLeftMostChild();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
		 System.out.print(node.getNodeValue() + " ");
	 }
	public void uiTraverse(BNode node, BSTPane pane){}
}
