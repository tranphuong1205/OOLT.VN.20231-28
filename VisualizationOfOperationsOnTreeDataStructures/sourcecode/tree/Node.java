package tree;

public class Node {
	private int value;
	private Node left;
	private Node right;
	
	public Node(int x) {
		this.value = x;
		this.left = null;
		this.right = null;
	}
	
	public int getNodeValue() {
		return value;
	}
	public Node getLeft() {
		return this.left;
	}
	public Node getRight() {
		return this.right;
	}
	public boolean lessThan(Node node) {
		return this.getNodeValue() <= node.getNodeValue();
	}
	public boolean greaterThan(Node node) {
		return this.getNodeValue() > node.getNodeValue();
		
}
	
	
}
