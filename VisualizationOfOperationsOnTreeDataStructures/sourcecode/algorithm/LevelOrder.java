package algorithm;

import tree.Node;
import java.util.LinkedList;
import java.util.Queue;

 public class LevelOrder implements Algorithm{
	 public void traverse(Node root) {
		 Queue<Node> nodeList = new LinkedList<Node>();
			nodeList.add(root);
			while(!nodeList.isEmpty()) {
				Node temp = nodeList.poll();
				System.out.print(temp.getNodeValue()+ " -> ");
				if(temp.getLeft() != null) {
					nodeList.add(temp.getLeft());
				}
				if(temp.getRight() != null) {
					nodeList.add(temp.getRight());
				}
			}
	 }
}
