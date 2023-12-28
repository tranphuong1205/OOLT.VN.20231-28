package algorithm;
import tree.Node;
 public class InOrder implements Algorithm{
	 public void traverse(Node root) {
		 if(root == null) {
				return;}
			traverse(root.getLeft());
			System.out.print(root.getNodeValue() + "-> ");
			traverse(root.getRight());
	 }
}