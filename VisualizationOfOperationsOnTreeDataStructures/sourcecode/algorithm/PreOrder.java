package algorithm;
import tree.Node;
public class PreOrder implements Algorithm {
	public void traverse(Node root) {
		if(root == null) {
			return;}
		System.out.print(root.getNodeValue() + "-> ");
		traverse(root.getLeft());
		traverse(root.getRight());
	}
	
}
