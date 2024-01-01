package algorithm;
import tree.BNode;
import tree.GenericNode;
 public  class InOrder implements Algorithm{
	 public void traverse(BNode root) {
		 if(root == null) {
				return;}
			traverse(root.getLeft());
			System.out.print(root.getNodeValue() + "-> ");
			traverse(root.getRight());
	 }
	 public void traverse( GenericNode node) {
		 if(node == null) return ;
		 GenericNode p = node.getLeftMostChild();
		 traverse(p);
		 System.out.print(node.getNodeValue() + " ");
		 if(p != null)
			 p = p.getRightSibling();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
	 }
	
}
