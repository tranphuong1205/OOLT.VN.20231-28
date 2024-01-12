package hedspi.group28.model.tree;

public class AVLNode extends BNode  {
	
	private int height;
	public AVLNode(int x) {
		super(x);
		this.height = 1;
		
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int x) {
		this.height = x;
	}
	
	public AVLNode getLeft() {
		return (AVLNode) left;
	}
	public AVLNode getRight() {
		return (AVLNode) right;
	}

	public void setLeft(AVLNode node) {
		this.left = node;
	}
	public void setRight(AVLNode node) {
		this.right = node;
	}
	public boolean lessThan(AVLNode node) {
		return this.getNodeValue() <= node.getNodeValue();
	}
	public boolean greaterThan(AVLNode node) {
		return this.getNodeValue() > node.getNodeValue();}
	
}
