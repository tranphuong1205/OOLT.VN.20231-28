package binaryTree.tree;

import binaryTree.Node;

public abstract class Tree {
    public Node rootNode;
    
    //************************************************************
  	//                  SEARCH NODE
  	//************************************************************
    public Node search(int value) {
        return searchRecursive(rootNode, value);
    }

    private Node searchRecursive(Node node, int value) {
        if (node == null || node.getValue() == value) {
            return node;
        }

        if (value < node.getValue()) {
            return searchRecursive(node.getLeftChild(), value);
        } else {
            return searchRecursive(node.getRightChild(), value);
        }
    }

    //************************************************************
  	//                  UPDATE NODE
  	//************************************************************
    public void updateNode(int currentValue, int newValue) {
        deleteNode(currentValue); // Xoá nút cần cập nhật
        insertNode(newValue); // Thêm nút mới với giá trị mới
    }
 
    public abstract void deleteNode(int value);

    //************************************************************
  	//                  INSERT NODE
  	//************************************************************
    public void insertNode(int Value) {
    	Node checkChild = search(Value);
    	if (rootNode == null) {
    		rootNode = new Node(Value);
        } else if (checkChild != null) {
            System.out.println("Child node with value " + Value + " already exists.");
        } else {
        	insert(rootNode,Value);
        }
    }
    
    public Node insert(Node node, int Value) {
        return node;
    }

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
}
