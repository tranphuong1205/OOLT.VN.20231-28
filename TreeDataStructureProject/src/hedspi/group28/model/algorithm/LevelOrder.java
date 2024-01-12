package hedspi.group28.model.algorithm;

import hedspi.group28.model.tree.BNode;
import hedspi.group28.model.tree.GenericNode;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder implements Algorithm{
	private LinkedList<Integer> traversalList = new LinkedList<>();
	
	 public void traverse(BNode root) {
		Queue<BNode> nodeList = new LinkedList<BNode>();
		nodeList.add(root);
		while(!nodeList.isEmpty()) {
			BNode temp = nodeList.poll();
			traversalList.add(temp.getNodeValue());
			if(temp.getLeft() != null) {
				nodeList.add(temp.getLeft());
			}
			if(temp.getRight() != null) {
				nodeList.add(temp.getRight());
			}
		}
	 }
	 
	 public void traverse(GenericNode node) {
		    if (node == null) return;
		    Queue<GenericNode> queue = new LinkedList<>();
		    queue.offer(node);
		    while (!queue.isEmpty()) {
		        GenericNode p = queue.poll();
		        traversalList.add(p.getNodeValue());
		        GenericNode q = p.getLeftMostChild();
		        while (q != null) {
		            queue.offer(q);
		            q = q.getRightSibling();
		        }
		    }
		}

	public LinkedList<Integer> getTraversalList() {
	    return traversalList;
	}
}
