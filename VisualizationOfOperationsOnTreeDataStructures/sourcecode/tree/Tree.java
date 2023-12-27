package tree;

public abstract class Tree {
	private Node root;
	public Tree() {
		this.setRoot(null);
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public void traverse(String algorithm) {
		
	}
	public abstract void insert( int  parentNodeValue, int  newNodeValue);
	public abstract void delete(int  nodeValue);
	public abstract void update(int currNodeValue, int newValue);
	public abstract void search(int nodeValue);
	
	
	}

