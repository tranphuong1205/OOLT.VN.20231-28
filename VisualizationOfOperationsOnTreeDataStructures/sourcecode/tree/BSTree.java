package tree;
import algorithm.Algorithm;
public class BSTree extends Tree {
	
	public void insert( int parentNodeValue, int  newNodeValue) {
		Node node = new Node(newNodeValue);
		this.setRoot(insert(this.getRoot(),node));
		//System.out.print(newNodeValue + " had been inserted");
	};
	
	private Node insert( Node root, Node newNode) {
		if(root == null) {
			return newNode;
		}
		if(root.lessThan(newNode)) {
			 root.setRight(insert(root.getRight(), newNode));
		}
		else {
			root.setLeft(insert(root.getLeft(), newNode));
		}
		return root;
		
	}
	
	public  void delete(int  nodeValue) {
		this.setRoot(delete(this.getRoot(), nodeValue));
	};
	
	private Node delete(Node root, int nodeValue) {
		if(root == null) {
			return null;
		}
		if(root.getNodeValue() == nodeValue) {
			if(root.getLeft() == null) {
				return root.getRight();		
				}
			Node max = root.getLeft();
			Node preNode = max;
			while(max.getRight() != null) {
				preNode = max;
				max = max.getRight();
			}
			max.setRight(root.getRight());
			if(max != root.getLeft()) {
				max.setLeft(root.getLeft());
				preNode.setRight(null);
			}
			return max;
			
			
		}
		if(root.getNodeValue() > nodeValue) {
			root.setLeft(delete(root.getLeft(), nodeValue));
		}
		else {
			root.setRight(delete(root.getRight(), nodeValue));
		}
		return root;
	}
	
	public void  update(int currValue, int newValue) {
		
	};
	
	public  Node search(int nodeValue) {
		return search(this.getRoot(), nodeValue);
	}
	
	private Node search(Node root, int nodeValue) {
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
		
	}
	
}
