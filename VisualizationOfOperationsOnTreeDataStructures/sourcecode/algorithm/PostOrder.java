package algorithm;
import tree.Node;
public class PostOrder implements Algorithm {
	public void traverse(Node root) {
		if(root == null) {
			return;}
		traverse(root.getLeft());
		traverse(root.getRight());
		System.out.print(root.getNodeValue() + "-> ");
	}
}
