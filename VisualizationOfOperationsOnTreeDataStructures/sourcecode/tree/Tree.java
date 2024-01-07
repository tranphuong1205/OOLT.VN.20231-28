package tree;

import algorithm.Algorithm;

public abstract class Tree {
	protected Node root;
	public Tree() {
		this.setRoot(null);
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public abstract void insert( int  parentNodeValue, int  newNodeValue);
	public abstract void delete(int  nodeValue);
	public abstract void update(int currNodeValue, int newValue);
	public abstract Node search(int nodeValue);
	public abstract void traverse(Algorithm algorithm);
	
	}

