package test;

import binaryTree.Algorithm;
import binaryTree.Node;
import binaryTree.tree.BST;

public class BST_Test {

	public static void main(String[] args) {
		// Tạo một cây tìm kiếm nhị phân (BST)
		BST bst = new BST();
		
		// Thêm các nút vào cây
		bst.insertNode(3);
		bst.insertNode(7);
		bst.insertNode(4);
		bst.insertNode(2);
		bst.insertNode(8);
		bst.insertNode(9);
		bst.insertNode(10);
		bst.insertNode(0);
		bst.insertNode(5);
		bst.insertNode(1);
		bst.insertNode(1); // thử thêm node trùng giá trị 
		
		// Hiển thị cây để kiểm tra kết quả
		displayTree(bst.rootNode,0);
		
		// Tìm kiếm node
		System.out.println("Tìm kiếm node 6:");
		Node searchResult = bst.search(6);
		if (searchResult != null) {
		    System.out.println("Node with value 6 found.");
		} else {
		    System.out.println("Node with value 6 not found.");
		}
	
		// Xóa node
		bst.deleteNode(4);
		bst.deleteNode(8);
		
		// Hiển thị cây sau khi xóa node
		System.out.println("Hiển thị cây sau khi xóa node 4 và 8:");
		displayTree(bst.rootNode, 0);
		
		// Cập nhật giá trị node
		bst.updateNode(3, 10);
		
		// Hiển thị cây sau khi cập nhật node
		System.out.println("Hiển thị cây sau khi cập nhật node 3 thành 10:");
		displayTree(bst.rootNode,0);
		
		Algorithm algorithm = new Algorithm();
		// Duyệt cây bằng thuật toán DFS
		System.out.println("DFS traversal:");  
		algorithm.DFS(bst.rootNode);
		System.out.println();
		
		// Duyệt cây bằng thuật toán BFS
		System.out.println("BFS traversal:");
		    algorithm.BFS(bst.rootNode);
		    System.out.println();
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


