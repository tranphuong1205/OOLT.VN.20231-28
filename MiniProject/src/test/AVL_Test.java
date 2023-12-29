package test;

import binaryTree.Node;
import binaryTree.tree.AVL;
public class AVL_Test {

    public static void main(String[] args) {
        // Tạo AVLTree
        AVL avlTree = new AVL();
        
        avlTree.insertNode(4);    
        avlTree.insertNode(3);            
        avlTree.insertNode(2);           
        avlTree.insertNode(1);        
        avlTree.insertNode(0);    
        avlTree.insertNode(7);   
        avlTree.insertNode(10);  
        avlTree.insertNode(2);   
        avlTree.insertNode(5); 
        avlTree.insertNode(6);   
        avlTree.insertNode(8); 
        avlTree.insertNode(9); 
        System.out.println(avlTree.rootNode.getValue());
        displayTree(avlTree.rootNode, 0);
     
        // Hiển thị cây để kiểm tra kết quả
        //displayTree(avlTree.rootNode, 0);
        
     // Tìm kiếm node
     		System.out.println("Tìm kiếm node 6:");
     		Node searchResult = avlTree.search(3);
     		if (searchResult != null) {
     		    System.out.println("Node with value 6 found.");
     		} else {
     		    System.out.println("Node with value 6 not found.");
     		}
    }
    
    public static void displayTree(Node node, int space) {
	    if (node == null)
	        return;
	    space+=5;
	    // Duyệt qua nút bên phải trước
	    displayTree(node.getRightChild(),space);
	    // In khoảng trắng để căn lề cho nút hiện tại
	    for (int i = 5; i < space; i++)
	        System.out.print(" ");
	    // In giá trị và độ cao của nút
	    System.out.println(node.getValue() + " (" + node.getHeight() + ") ");
	    // Duyệt qua nút bên trái
	    displayTree(node.getLeftChild(),space);
	}
}
