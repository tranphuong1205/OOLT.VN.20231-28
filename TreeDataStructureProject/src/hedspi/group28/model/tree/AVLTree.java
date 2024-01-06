package hedspi.group28.model.tree;

import hedspi.group28.model.algorithm.Algorithm;

public class AVLTree extends BSTree{
	private AVLNode root;
	
	public AVLTree() {
		this.setRoot(null);
	}
	
	public AVLNode getRoot() {
		return root;
	}
	public void setRoot(AVLNode root) {
		this.root = root;
	}
	
	private AVLNode rightRotate(AVLNode node) {
		AVLNode x = node.getLeft();
		AVLNode y = x.getRight();
		x.setRight(node);
		node.setLeft(y);
		node.setHeight(max(height(node.getLeft()), height(node.getRight()) +1));
		x.setHeight(max(height(x.getLeft()),height( x.getRight()) +1));
		return x;
	}
	
	private AVLNode leftRotate(AVLNode node) {
		AVLNode x = node.getRight();
		AVLNode y = x.getLeft();
		x.setLeft(node);
		node.setRight(y);
		node.setHeight(max(height(node.getLeft()),height( node.getRight()) +1)) ;
		x.setHeight(max(height(x.getLeft()),height( x.getRight()) +1));
		return x;
	}
	
	public int getBalance(AVLNode node) {
		if(node == null) {
			return 0;
		}
		return height(node.getLeft()) - height(node.getRight());
		
	}
	
	public int height(AVLNode node) {
		if(node == null)
			return 0;
		return node.getHeight();
		}
	
	private  int max (int a, int b) {
	      return (a > b) ? a : b;
	   }
	
	private AVLNode minValue(AVLNode node) {
		AVLNode x = node;
		while(x.getLeft() != null) {
			x = x.getLeft();
		}
		return x;
	}
	
	public  void insert( int  parentNodeValue, int  newNodeValue) {
		this.setRoot(insert(this.getRoot(),newNodeValue));
		//System.out.print(newNodeValue);
	};
	
	private AVLNode insert(AVLNode node, int value) {
		if(node == null) {
			return new AVLNode(value);
		}
		if(value < node.getNodeValue()) {
			node.setLeft(insert(node.getLeft(), value));
		}
		else if(value > node.getNodeValue()) {
			node.setRight(insert(node.getRight(), value));
		}
		else return node;
		
		node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
		int balance = getBalance(node);
		if(balance > 1 && value < node.getLeft().getNodeValue()) {
			return rightRotate(node);
		}
		if(balance < -1 && value > node.getRight().getNodeValue()) {
			return leftRotate(node);
		}
		if(balance > 1 && value > node.getLeft().getNodeValue()) {
			node.setLeft(leftRotate(node.getLeft()));
			return rightRotate(node);
		}
		if(balance < -1 && value < node.getRight().getNodeValue()) {
			node.setRight(rightRotate(node.getRight()));
			return leftRotate(node);
		}
		return node;
	}
	
	public  void delete(int  nodeValue) {
		this.setRoot(delete(this.root, nodeValue));
		
	};
	
	private AVLNode delete(AVLNode node, int value) {
		if(node == null) {
			return null;
		}
		if(value < node.getNodeValue()) {
			node.setLeft(delete(node.getLeft(), value));
		}
		else if(value > node.getNodeValue()) {
			node.setRight(delete(node.getRight(),value));
		}
		else {
			if(node.getLeft() == null || node.getRight() == null) {
				AVLNode temp = null;
				if(node.getLeft() == null)
					temp = node.getRight();
				else 
					temp = node.getLeft();
				if(temp == null) {
					temp = node;
					node = null;
				}
				else 
					node = temp;
			}
			else {
				AVLNode temp = minValue(node.getRight());
				node.setValue(temp.getNodeValue());
				node.setRight(delete(node.getRight(), temp.getNodeValue()));
			}
		}
		if(node  == null)
			return null;
		node.setHeight(max(height(node.getLeft()),height( node.getRight()) +1));
		int balance = getBalance(node);
		if(balance >1 && getBalance(node.getLeft()) >= 0) {
			return rightRotate(node);
		}
		if(balance > 1 && getBalance(node.getLeft()) < 0) {
			node.setLeft(leftRotate(node.getLeft()));
			return rightRotate(node);
		}
		if(balance < -1 && getBalance(node.getRight()) <= 0) {
			return leftRotate(node);
		}
		if(balance < -1 && getBalance(node.getRight()) > 0) {
			node.setRight(rightRotate(node.getRight()));
			return leftRotate(node);
		}
		return node;
	}
	
	public  void update(int currNodeValue, int newValue) {
		
	};
	public  AVLNode search(int nodeValue) {
		return search(this.getRoot(), nodeValue);
	};
	
	private AVLNode search(AVLNode root, int nodeValue) {
		if(root == null) {
			return null;
		}
		if(root.getNodeValue() == nodeValue) {
			return root;
		}
		if(root.getNodeValue()< nodeValue) {
			return search(root.getRight(), nodeValue);
		}
		else {
			return search(root.getLeft(), nodeValue);
		}
	}
	
	public void traverse(Algorithm algorithm) {
		algorithm.traverse(this.getRoot());
	};
	
}
