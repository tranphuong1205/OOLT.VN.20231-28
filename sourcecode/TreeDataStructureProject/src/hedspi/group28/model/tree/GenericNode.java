package hedspi.group28.model.tree;

public class GenericNode extends Node {
	private GenericNode leftMostChild;
	private GenericNode rightSibling;

	
	public GenericNode(int x) {
		super(x);
		this.setLeftMostChild(null);
		this.setRightSibling(null);
	}

	public GenericNode getLeftMostChild() {
		return leftMostChild;
	}
		


	public void setLeftMostChild(GenericNode leftMostChild) {
		this.leftMostChild = leftMostChild;
	}

	public GenericNode getRightSibling() {
		return rightSibling;
	}

	public void setRightSibling(GenericNode rightSibling) {
		this.rightSibling = rightSibling;
	}
	

}
