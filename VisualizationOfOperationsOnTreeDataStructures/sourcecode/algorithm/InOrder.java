package algorithm;
import tree.BNode;
import tree.GenericNode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public  class InOrder implements Algorithm{
	 private ScheduledExecutorService executorService;
	public InOrder() {
		this.executorService = Executors.newSingleThreadScheduledExecutor();
	}
	 public void traverse(BNode root) {
		 if(root == null) {
				return;}
		 traverseWithDelay(root);

			/*traverse(root.getLeft());
			System.out.print(root.getNodeValue() + "-> ");
			root.isVisited = true;
			traverse(root.getRight());*/
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
	 private void traverseWithDelay(BNode node) {
		 if (node != null) {
			 executorService.schedule(() -> {
				 System.out.print(node.getNodeValue() + "-> ");
				 node.setVisited(true);
				 traverse(node.getRight());
			 }, 2, TimeUnit.SECONDS);
		 }
	 }
	
}
