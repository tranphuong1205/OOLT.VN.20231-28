package binaryTree.tree;

import binaryTree.Node;

public class BST extends Tree {

	//************************************************************
  	//                  DELETE NODE
  	//************************************************************
    @Override
    // Xóa node
    public void deleteNode(int value) {
        rootNode = deleteRecursive(rootNode, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) return null;
        if (value < node.value) {
            node.setLeftChild(deleteRecursive(node.getLeftChild(), value));
        } else if (value > node.value) {
            node.setRightChild(deleteRecursive(node.getRightChild(), value));
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            } else {
                // Node có cả hai con
                node.setValue(findMinValue(node.getRightChild()));
                node.setRightChild(deleteRecursive(node.getRightChild(), node.getValue()));
            }
        }
        // Cập nhật lại chiều cao của nút sau khi xóa
        int leftHeight = (node.getLeftChild() == null) ? 0 : node.getLeftChild().getHeight();
        int rightHeight = (node.getRightChild() == null) ? 0 : node.getRightChild().getHeight();
        node.setHeight(1 + Math.max(leftHeight, rightHeight));

        return node;
    }

    private int findMinValue(Node node) {
        int minValue = node.getValue();
        while (node.getLeftChild() != null) {
            minValue = node.getLeftChild().getValue();
            node = node.getLeftChild();
        }
        return minValue;
    }
  
    //************************************************************
  	//                  INSERT NODE
  	//************************************************************
    @Override
    public Node insert(Node node, int Value) {
        if (node == null) return new Node(Value);
        if (Value < node.getValue()) 
            node.setLeftChild(insert(node.getLeftChild(), Value));
        else if (Value > node.getValue()) 
            node.setRightChild(insert(node.getRightChild(), Value));
        // Cập nhật chiều cao của nút cha dựa vào chiều cao của nút con
        int leftHeight = (node.getLeftChild() == null) ? 0 : node.getLeftChild().getHeight();
        int rightHeight = (node.getRightChild() == null) ? 0 : node.getRightChild().getHeight();
        node.setHeight(1 + Math.max(leftHeight, rightHeight));
        return node;
    }

}
