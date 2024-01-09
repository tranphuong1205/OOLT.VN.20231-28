package hedspi.group28.controller.tree;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.Queue;

import hedspi.group28.model.tree.GenericNode;
import hedspi.group28.model.tree.GenericTree;
import hedspi.group28.view.NodeView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class GenController {
	
	//private TreeViewHistory treeViewHistory;

	@FXML private Button Insert;
	@FXML private Button Remove;
	@FXML private Button Update;
	@FXML private Button Traverse;
	@FXML private Button Search;
	@FXML private Pane TreeView;
	@FXML private ComboBox<String> Algorithms;
	@FXML private TextField t10;
	@FXML private TextField t20;
	@FXML private Button b30;
	@FXML private TextField t11;
	@FXML private Button b21;
	@FXML private TextField t12;
	@FXML private TextField t22;
	@FXML private Button b32;
	@FXML private TextField t14;
	@FXML private Button b24;
	
	public void initialize() {
		Insert.setOnAction(e -> handleInsert());
		Remove.setOnAction(e -> handleRemove());
		Update.setOnAction(e -> handleUpdate());
		Traverse.setOnAction(e -> handleTraverse());
		Search.setOnAction(e -> handleSearch());
		
		b30.setOnAction(e -> handleb30());	// button insertOK
		b21.setOnAction(e -> handleb21());	// button removeOK
		b32.setOnAction(e -> handleb32());	// button updateOK
		b24.setOnAction(e -> handleb24());	// button searchOK
		
		Algorithms.getItems().addAll(
        		"InOrder",
        		"PreOrder",
                "PostOrder",
        		"LevelOrder"
        );

		// Set event handler for ComboBox
	    Algorithms.setOnAction(e -> {
	        String selected = Algorithms.getSelectionModel().getSelectedItem();
	        //Algorithms.setValue(null);
	        Algorithms.setVisible(false); 
	        switch (selected) {
	            case "InOrder":           	
	            	InOrder(tree.getRoot());
	                break;
	            case "PreOrder":
	            	PreOrder(tree.getRoot());
	                break;
	            case "PostOrder":        	
	            	PostOrder(tree.getRoot());
	                break;
	            case "LevelOrder":        	
	            	LevelOrder(tree.getRoot());
	                break;
	        }
	    });
    }
	
	GenericTree tree = new GenericTree();
	
    @FXML
    public void handleInsert() {			// hien thi button 
        t10.setVisible(true);
        if (tree.getRoot() != null) t20.setVisible(true);
        b30.setVisible(true);
    }
    
    public void handleb30() {			// xử lý sự kiện insert 
    	String text1 = t10.getText();	// lấy giá trị được nhập vào TextField 
    	String text2 = t20.getText();	// lấy giá trị được nhập vào TextField 
    	t10.setVisible(false); t20.setVisible(false); b30.setVisible(false);
    	try {
    		int parent = Integer.parseInt(text1); // Chuyển đổi chuỗi thành số nguyên
    		if (tree.getRoot() == null) {
    			tree.insert(parent, 0);
	    	    drawTree(parent);
    		} else {
    			 	int child = Integer.parseInt(text2); // Chuyển đổi chuỗi thành số nguyên
    			 	tree.insert(parent, child);
		    	    drawTree(child);
    		}
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
            drawTree(number2);          
    	} catch (NumberFormatException e) {
    	    //System.out.println("Không thể chuyển đổi chuỗi thành số nguyên.");
    	}
    }
    
    // Duyệt cây
    
    @FXML
    public void handleTraverse() {			// hien thi button 
    	Algorithms.setVisible(true);       
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
      
    private void drawTree(int refNode) {
    	TreeView.getChildren().clear();
    	drawTree(tree.getRoot(), TreeView, 400, 50, 0, refNode);
    }
    // Hide Button
    private void HideButton() {
    	Algorithms.setVisible(false); 
    	t10.setVisible(false); 
    	t20.setVisible(false); 
    	b30.setVisible(false); 
    	t11.setVisible(false); 
    	b21.setVisible(false); 
    	t12.setVisible(false); 
    	t22.setVisible(false); 
    	b32.setVisible(false); 
    	t14.setVisible(false); 
    	b24.setVisible(false); 
    }
    
    // Draw Tree
    private double radius = 15;
    private double vGap = 50;

    private void drawTree(GenericNode node, Pane treePane, double x, double y, int level, int refNode) {
        if (node != null) {
            int numChildren = countChildren(node.getLeftMostChild());
            double xStart = x - (numChildren - 1) * 50; // Điều chỉnh khoảng cách giữa các node con
            double yChild = y + vGap;
            NodeView nodeView = new NodeView(node.getNodeValue(), x, y);
            if(node.getNodeValue() == refNode)            	
        		nodeView.setColor(Color.RED);   
            
            nodeView.addToPane(treePane);

            if (node.getLeftMostChild() != null) {
                GenericNode child = node.getLeftMostChild();
                for (int i = 0; i < numChildren; i++) {
                    double xChild = xStart + i * 100; // Điều chỉnh khoảng cách
                    Line line = new Line(x, y + radius, xChild, yChild - radius);
                    treePane.getChildren().add(line);
                    line.toBack();
                    drawTree(child, treePane, xChild, yChild, level + 1, refNode);
                    child = child.getRightSibling();
                }
            }
        }
    }

    private int countChildren(GenericNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.getRightSibling();
        }
        return count;
    }	
    
    private void PostOrder(GenericNode node) {
        if (node == null) return;
        Queue<GenericNode> queue = new LinkedList<>();
        queue.offer(node);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            GenericNode p = queue.poll();
            if (p != null) {
                drawTree(p.getNodeValue());
                GenericNode q = p.getLeftMostChild();
                while (q != null) {
                    queue.offer(q);
                    q = q.getRightSibling();
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        //Algorithms.setValue(null);
    }
    
    public void PreOrder(GenericNode node) {
        if (node == null) return;
        Timeline timeline = new Timeline();
        PreOrderNode(node, timeline);
        //Algorithms.setValue(null);
    }

    private void PreOrderNode(GenericNode node, Timeline timeline) {
        if (node != null) {
            drawTree(node.getNodeValue());
            GenericNode p = node.getLeftMostChild();
            while (p != null) {
                final GenericNode currentNode = p;
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
                	PreOrderNode(currentNode, timeline);
                }));
                p = p.getRightSibling();
            }
        }
        timeline.play();
    }
    
    public void InOrder(GenericNode node) {
        if (node == null) return;
        InOrderNode(node);
        //Algorithms.setValue(null);
    }

    private void InOrderNode(GenericNode node) {
        if (node == null) return;
        GenericNode p = node.getLeftMostChild();
        while (p != null) {
        	InOrderNode(p);
            p = p.getRightSibling();
        }
        drawTree(node.getNodeValue());
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {}));
        timeline.play();
    }

    public void LevelOrder(GenericNode node) {
        if (node == null) return;

        Queue<GenericNode> queue = new LinkedList<>();
        queue.offer(node);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            GenericNode p = queue.poll();
            if (p != null) {
                drawTree(p.getNodeValue());
                System.out.print(p.getNodeValue() + " ");
                GenericNode q = p.getLeftMostChild();
                while (q != null) {
                    queue.offer(q);
                    q = q.getRightSibling();
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
}