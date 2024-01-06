package hedspi.group28.controller.tree;

import javafx.scene.paint.Color;
import hedspi.group28.model.tree.AVLNode;
import hedspi.group28.model.tree.AVLTree;
import hedspi.group28.view.NodeView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
public class AVLController {
	
	@FXML private Button Insert;
	@FXML private Button Remove;
	@FXML private Button Update;
	@FXML private Button Traverse;
	@FXML private Button Search;
	
	@FXML private Pane TreeView;
	
	@FXML private TextField t10;
	@FXML private Button b20;
	@FXML private TextField t11;
	@FXML private Button b21;
	@FXML private TextField t12;
	@FXML private TextField t22;
	@FXML private Button b32;
	@FXML private TextField t14;
	@FXML private Button b24;
	
	@FXML private Button About;

	public void initialize() {
		Insert.setOnAction(e -> handleInsert());
		Remove.setOnAction(e -> handleRemove());
		Update.setOnAction(e -> handleUpdate());
		Traverse.setOnAction(e -> handleTraverse());
		Search.setOnAction(e -> handleSearch());
		b20.setOnAction(e -> handleb20());
		b21.setOnAction(e -> handleb21());
		b32.setOnAction(e -> handleb32());
		b24.setOnAction(e -> handleb24());
    }
	
	AVLTree tree = new AVLTree();
	
    @FXML
    public void handleInsert() {			// hien thi button 
        t10.setVisible(true);
        b20.setVisible(true);
    }
    
    public void handleb20() {			// xử lý sự kiện insert 
    	String text = t10.getText();	// lấy giá trị được nhập vào TextField 
    	t10.setVisible(false); b20.setVisible(false);
    	try {
    		int number = Integer.parseInt(text); // Chuyển đổi chuỗi thành số nguyên
    		tree.insert(0, number);	
    		drawTree(number);
    	} catch (NumberFormatException e) {
    	    //System.out.println("Không thể chuyển đổi chuỗi thành số nguyên.");
    	}	
    }
    
    @FXML
    public void handleRemove() {			// hien thi button 
        t11.setVisible(true);
        b21.setVisible(true);
    }
    
    public void handleb21() {
    	String text = t11.getText();	// lấy giá trị được nhập vào TextField
    	t11.setVisible(false); b21.setVisible(false);
    	try {
    		int number = Integer.parseInt(text); // Chuyển đổi chuỗi thành số nguyên
            if(tree.search(number)!=null) {
	        	tree.delete(number); // Xóa node khỏi cây 
	        	drawTree(number);
        	}       
    	} catch (NumberFormatException e) {
    	    //System.out.println("Không thể chuyển đổi chuỗi thành số nguyên.");
    	}
    }
    
    @FXML
    public void handleUpdate() {			// hien thi button 
        t12.setVisible(true);
        t22.setVisible(true);
        b32.setVisible(true);
    }
    
    public void handleb32() {
    	String text1 = t12.getText();	// lấy giá trị được nhập vào TextField 
    	String text2 = t22.getText();	// lấy giá trị được nhập vào TextField 
    	t12.setVisible(false); t22.setVisible(false); b32.setVisible(false);
    	try {
    		int number1 = Integer.parseInt(text1); // Chuyển đổi chuỗi thành số nguyên
    		int number2 = Integer.parseInt(text2); // Chuyển đổi chuỗi thành số nguyên
    		tree.update(number1, number2);
    		drawTree(number1);
    	} catch (NumberFormatException e) {
    	    //System.out.println("Không thể chuyển đổi chuỗi thành số nguyên.");
    	}
    }
    
    @FXML
    public void handleTraverse() {			// hien thi button 
       
        
    }
    


    
    @FXML
    public void handleSearch() {			// hien thi button 
        t14.setVisible(true);
        b24.setVisible(true);
    }
    
    public void handleb24() {
    	String text = t14.getText();	// lấy giá trị được nhập vào TextField 
    	t14.setVisible(false); b24.setVisible(false);
    	try {
	   		int SearchValue = Integer.parseInt(text); // Chuyển đổi chuỗi thành số nguyên
	   		drawTree(SearchValue);
    	} catch (NumberFormatException e) {
    	    //System.out.println("Không thể chuyển đổi chuỗi thành số nguyên.");
    	}	
    }
    
    public void drawTree(int refNode) {
    	TreeView.getChildren().clear();
		int maxdepth = treeDepth(tree.getRoot());
    	drawTree(tree.getRoot(), TreeView, 400, 50, 1, refNode, maxdepth);
    }
     
    public void drawTree(AVLNode node, Pane pane, double x, double y, int level, int refNode, int maxdepth) {
        if (node != null) {
            NodeView nodeView = new NodeView(node.getNodeValue(), x, y);
            
            if (node.getNodeValue() == refNode) {
                nodeView.setColor(Color.RED);
            }
            nodeView.addToPane(pane);

            int numOfChildren = (node.getLeft() != null ? 1 : 0) + (node.getRight() != null ? 1 : 0);
            double horizontalOffset = maxdepth*30/(level)-30;
            double xLeft = x - 50 - numOfChildren * horizontalOffset;
            double xRight = x + 50 + numOfChildren * horizontalOffset;

            // Tính toán khoảng cách dọc dựa trên độ cao của node
            double verticalOffset = (600 - 50*level)/maxdepth; // Điều chỉnh khoảng cách dọc theo độ cao
            double yNext = y + verticalOffset;

            if (node.getLeft() != null) {
                Line leftLine = new Line(x, y + 20, xLeft, yNext);
                pane.getChildren().add(leftLine);
                drawTree(node.getLeft(), pane, xLeft, yNext, level + 1, refNode, maxdepth);
            }
            if (node.getRight() != null) {
                Line rightLine = new Line(x, y + 20, xRight, yNext);
                pane.getChildren().add(rightLine);
                drawTree(node.getRight(), pane, xRight, yNext, level + 1, refNode, maxdepth);
            }
        }
    }
    
    public int treeDepth(AVLNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = treeDepth(node.getLeft());
            int rightDepth = treeDepth(node.getRight());

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }  
}
