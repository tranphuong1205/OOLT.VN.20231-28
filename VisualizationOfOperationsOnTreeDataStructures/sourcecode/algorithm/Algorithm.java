package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
	
	public void pre_order(Node node) {
		if(node == null) {
			return;}
		System.out.print(node.getNodeValue() + "-> ");
		pre_order(node.getLeft());
		pre_order(node.getRight());
	}
	
	public void in_order(Node node) {
		if(node == null) {
			return;}
		in_order(node.getLeft());
		System.out.print(node.getNodeValue() + "-> ");
		in_order(node.getRight());
	}
	
	public void post_order(Node node) {
		if(node == null) {
			return;}
		post_order(node.getLeft());
		post_order(node.getRight());
		System.out.print(node.getNodeValue() + "-> ");
		
	}
	
	public void level_order(Node node) {
		Queue<Node> nodeList = new LinkedList<Node>();
		nodeList.add(node);
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
