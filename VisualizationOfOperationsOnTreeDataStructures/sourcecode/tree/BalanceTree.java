package tree;

public class BalanceTree extends AVLTree {
	public AVLNode splay(AVLNode root, int x) {
		if(root == null || root.getNodeValue() == x) {
			return root;
		}
		if(root.getNodeValue() > x) {
			if(root.getLeft() == null) {
				return root;
			}
			if(root.getLeft().getNodeValue() > x) {
				root.getLeft().setLeft(splay(root.getLeft().getLeft(), x));
				root = rightRotate(root);
			}
			else if(root.getLeft().getNodeValue() < x) {
				root.getLeft().setRight(splay(root.getLeft().getRight(), x));
			
			if(root.getLeft().getRight() != null)
				root.setLeft(leftRotate(root.getLeft()));
		}
			return (root.getLeft() == null) ? root: rightRotate(root);
			}
		else {
			if(root.getRight() == null) {
				
				return root;
			}
			if(root.getRight().getNodeValue() > x) {
				root.getRight().setLeft(splay(root.getRight().getLeft(), x));
				if(root.getRight().getLeft() != null)
					root.setRight(rightRotate(root.getRight()));
			}
			else if(root.getRight().getNodeValue() < x) {
				root.getRight().setRight(splay(root.getRight().getRight(), x));
				root = leftRotate(root);
			}
			return (root.getRight() == null) ? root: leftRotate(root);
		}
	}
	public void insert(int x, int y) {
		this.setRoot(insert(this.getRoot(), y));
		//System.out.print(this.getRoot().getNodeValue());
	}
	private AVLNode insert(AVLNode root, int x) {
		AVLNode node = new AVLNode(x);
		if(root == null)
			return node;
		root = splay(root, x);
		if(root.getNodeValue() == x)
			return root;
		if(root.getNodeValue() > x) {
			node.setRight(root);
			node.setLeft(root.getLeft());
			root.setLeft(null);
		}
		else {
			node.setLeft(root);
			node.setRight(root.getRight());
			root.setRight(null);
		}
		return node;
	}
	
	public void delete(int x) {
		this.setRoot(delete(this.getRoot(),x));
	}
	private AVLNode delete(AVLNode root, int x) {
		AVLNode temp;
		if(root == null)
			return null;
		root = splay(root, x);
		if(root.getNodeValue() != x)
			return root;
		if(root.getLeft() == null) {
			temp = root;
			root = root.getRight();
		}
		else {
			temp = root;
			root = splay(root.getLeft(),x);
			root.setRight(temp.getRight());
		}
		return root;
	}
	
	public AVLNode search(int x) {
		return search(this.getRoot(), x);
	}
	
	private AVLNode search(AVLNode root,int x) {
		return splay(root,x);
	}
	
}
