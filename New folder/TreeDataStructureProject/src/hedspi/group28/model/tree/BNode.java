package hedspi.group28.model.tree;

public class BNode extends Node {
	protected BNode left;
	protected BNode right;
	
	public BNode(int x) {
		super(x);
		this.left = null;
		this.right = null;
	}

	public BNode getLeft() {
		return left;
	}
	public BNode getRight() {
		return right;
	}
	public void setLeft(BNode node) {
		this.left = node;
	}
	public void setRight(BNode node) {
		this.right = node;
	}
	public boolean lessThan(BNode node) {
		return this.getNodeValue() <= node.getNodeValue();
	}
	public boolean greaterThan(BNode node) {
		return this.getNodeValue() > node.getNodeValue();
		
}
	
	
}
