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
		return left;
	}
	public Node getRight() {
		return right;
	}
	public void setValue(int x) {
		this.value = x;
	}
	public void setLeft(Node node) {
		this.left = node;
	}
	public void setRight(Node node) {
		this.right = node;
	}
	public boolean lessThan(Node node) {
		return this.getNodeValue() <= node.getNodeValue();
	}
	public boolean greaterThan(Node node) {
		return this.getNodeValue() > node.getNodeValue();
		
}
	
	
}