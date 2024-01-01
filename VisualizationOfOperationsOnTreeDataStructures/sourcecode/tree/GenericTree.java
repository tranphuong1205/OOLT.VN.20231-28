package tree;

import algorithm.Algorithm;

public class GenericTree extends Tree {
	private GenericNode root;

	public GenericNode getRoot() {
		return root;
	}

	public void setRoot(GenericNode root) {
		this.root = root;
	}
	public void insert(int parentValue, int childValue) {
		this.setRoot(insert(this.root, parentValue, childValue));
	}
	
	private GenericNode insert(GenericNode root, int parentValue, int childValue) {
		GenericNode node = new GenericNode(childValue);
		if(root == null) {
			return node;
		}
		GenericNode h = search(parentValue);
		GenericNode temp = h.getLeftMostChild();
		h.setLeftMostChild(node);
		node.setRightSibling(temp);
		return root;
	}
	
	public void delete(int deleteValue) {
		this.setRoot(delete(this.root, deleteValue));
	}
	
	private GenericNode delete(GenericNode root, int deleteValue) {
		if(root == null) return null;
		GenericNode p = search(root, deleteValue);
		if(p == null) {
			System.out.print(" can't found "+ deleteValue);
			return root;
		}
		GenericNode q = parent(root, p);
		q.setLeftMostChild(p.getLeftMostChild());
		p = null;
		return root;
		
	}
	
	private GenericNode parent(GenericNode root, GenericNode p) {
		if(root == null) return null;
		GenericNode q = root.getLeftMostChild();
		while(q != null) {
			if(p == q) return root;
			GenericNode pp = parent(p, q);
			if(pp != null) return pp;
			q = q.getRightSibling();
		}
		return null;
	}
	
	public GenericNode search(int searchValue) {
		return search(this.getRoot(), searchValue);
	}
	
	private GenericNode search(GenericNode root, int searchValue) {
		if(root == null) return null;
		if(root.getNodeValue() == searchValue) return root;
		GenericNode p = root.getLeftMostChild();
		while(p != null) {
			GenericNode h = search(p, searchValue);
			if(h != null) return h;
			p = p.getRightSibling();
		}
		return null;
		}
	
	public void update(int crrV, int newV) {
		this.setRoot(update(this.root, crrV, newV));
	}
	
	private GenericNode update(GenericNode root, int crrV, int newV) {
		GenericNode p = search(root, crrV);
		if(p == null) return root;
		p.setValue(newV);
		return root;
	}
	
	public void traverse(Algorithm algorithm) {
		algorithm.traverse(this.getRoot());
	}
	
	
	
	
}