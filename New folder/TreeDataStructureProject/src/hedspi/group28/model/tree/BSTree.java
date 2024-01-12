package hedspi.group28.model.tree;
import hedspi.group28.model.algorithm.Algorithm;
public class BSTree extends Tree {
	public BNode getRoot() {
		return (BNode) root;
	}
	public void setRoot(BNode root) {
		this.root = root;
	}
	
	@Override
	public void insert(int parentNodeValue, int newNodeValue) {
	    if (root == null) {
	        this.setRoot(new BNode(newNodeValue));
	    } else if (search(newNodeValue) == null) 
	        insert(this.getRoot(), new BNode(newNodeValue));
	}

	private BNode insert(BNode root, BNode newNode) {
	    if (root == null) return newNode;
	    if (root.lessThan(newNode)) root.setRight(insert(root.getRight(), newNode));
	    else root.setLeft(insert(root.getLeft(), newNode));
	    return root;
	}
	
	@Override
	public  void delete(int  nodeValue) {
		this.setRoot(delete(this.getRoot(), nodeValue));
	};
	
	private BNode delete(BNode root, int nodeValue) {
		if(root == null) {
			return null;
		}
		if(root.getNodeValue() == nodeValue) {
			if(root.getLeft() == null) {
				return root.getRight();		
			}
			BNode max = root.getLeft();
			BNode preNode = max;
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
	
	@Override
	public void  update(int currValue, int newValue) {
		if (search(currValue)!=null && search(newValue)== null) {
			delete(currValue);
			insert(currValue,newValue);
		}
	};
	
	@Override
	public  BNode search(int nodeValue) {
		return search(this.getRoot(), nodeValue);
	}
	
	private BNode search(BNode root, int nodeValue) {
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
