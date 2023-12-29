package test;

import generalTree.*;
public class GenericTreeTest {

    public static void main(String[] args) {
        // Tạo GenericTree
        GenericTree tree = new GenericTree();

        tree.rootNode = new Node(1); // Tạo rootNode có giá trị là 1

        tree.insertNode(1,2);	// Tạo node 2 là con của node 1
        tree.insertNode(1,3);	// Tạo node 3 là con của node 1
        tree.insertNode(1,4);	// Tạo node 4 là con của node 1
        tree.insertNode(2,5);	// Tạo node 5 là con của node 2
        tree.insertNode(3,6);	// Tạo node 6 là con của node 3
        tree.insertNode(3,7);	// Tạo node 7 là con của node 3
        tree.insertNode(7,8);	// Tạo node 8 là con của node 7
        tree.insertNode(9,7);	// Trường hợp không tìm thấy node cha 
        tree.insertNode(4,2);	// Trường hợp tạo node trùng value 
        
        displayTree(tree.getRootNode(), 0);	// Hiển thị cây 
                
        // Kiểm tra phương thức tìm nút  
        System.out.print("Tìm kiếm nút 9:\n"); 
        Node foundNode = tree.search(9);
        if(foundNode!=null)
        	System.out.println("Node found."); 
        else System.out.println("Node not found."); 
        
        // Kiểm tra phương thức update
        System.out.print("Tìm kiếm và cập nhật giá trị của nút 2 thành nút 20:\n"); 
        foundNode = tree.search(2);
        if (foundNode != null) {
            tree.updateNode(2, 20);
        }
        displayTree(tree.getRootNode(), 0);	// Hiển thị cây kiểm tra kết quả  
	
        System.out.print("Xóa nút 3 khỏi cây:\n"); 
        tree.deleteNode(3);

        System.out.print("Hiển thị cây sau khi xóa nút:\n"); 
        displayTree(tree.getRootNode(), 0);
    
        Algorithm algorithm = new Algorithm();
        // Duyệt cây bằng thuật toán DFS
        System.out.println("DFS traversal:");  
        algorithm.DFS(tree.rootNode);
        System.out.println();

        // Duyệt cây bằng thuật toán BFS
        System.out.println("BFS traversal:");
        algorithm.BFS(tree.rootNode);
        System.out.println();
    }
	
    // Phương thức hiển thị cây để kiểm tra kết quả 
    public static void displayTree(Node node, int level) {
        if (node == null) {
            return;
        }
        // Hiển thị thông tin của node cùng với mức độ lồng
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(node.getValue() + " (" + node.getChildren().size() + ")");

        // Gọi đệ quy để hiển thị các node con
        for (Node child : node.getChildren()) {
            displayTree(child, level + 1);
        }
    }     
}
