package hedspi.group28.controller.tree;

import javafx.scene.paint.Color;

import java.util.LinkedList;

import hedspi.group28.model.algorithm.InOrder;
import hedspi.group28.model.algorithm.LevelOrder;
import hedspi.group28.model.algorithm.PostOrder;
import hedspi.group28.model.algorithm.PreOrder;
import hedspi.group28.model.tree.AVLNode;
import hedspi.group28.model.tree.AVLTree;
import hedspi.group28.view.NodeView;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
public class AVLController {
	
	@FXML private Button Insert;
	@FXML private Button Remove;
	@FXML private Button Update;
	@FXML private Button Traverse;
	@FXML private Button Search;
	@FXML private ImageView PauseButton;
	@FXML private ImageView NextButton;
	@FXML private ImageView PrevButton;
	@FXML private ImageView skipButton;
	@FXML private ImageView resetButton;
	@FXML private Pane TreeView;
	@FXML private ComboBox<String> Algorithms;
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
		
		Algorithms.getItems().addAll(
        		"InOrder",
        		"PreOrder",
                "PostOrder",
        		"LevelOrder"
        );

		// Set event handler for ComboBox
	    Algorithms.setOnAction(e -> {
	        String selected = Algorithms.getSelectionModel().getSelectedItem();
	        Algorithms.setVisible(false); 
	        traversalList = null;
	        currentIndex = 0;
	        switch (selected) {
	            case "InOrder":     
	            	drawThread=null;
	            	inOrder();
	            	isDrawThreadRunning= true;
	                break;
	            case "PreOrder":
	            	drawThread=null;
	            	preOrder();
	            	isDrawThreadRunning= true;
	                break;
	            case "PostOrder":  
	            	drawThread=null;
	            	postOrder();
	            	isDrawThreadRunning= true;
	                break;
	            case "LevelOrder":  
	            	drawThread=null;
	            	levelOrder();
	            	isDrawThreadRunning= true;
	                break;
	        }
	    });     	
    
	    PauseButton.setOnMouseClicked(event -> {	 
		    addClickAnimation(PauseButton);
		    if(drawThread != null && isDrawThreadRunning == true) {
		    	if(drawThread.isAlive())pauseThread();
		    } else if(drawThread != null) {
		    	if(drawThread.isAlive()) resumeThread();
		    	else traverse();
		    }
		    //setPlayImage();
	    });
	    
	    PrevButton.setOnMouseClicked(event -> {
	    	addClickAnimation(PrevButton);
	    	if(currentIndex > 0) {
		    	currentIndex--;
		    	drawTree(traversalList.get(currentIndex));
	    	}
	    });
	    
	    NextButton.setOnMouseClicked(event -> {
	    	addClickAnimation(NextButton);
	    	if(currentIndex < traversalList.size()-1) {
		    	currentIndex++;	
		    	drawTree(traversalList.get(currentIndex));
	    	}
	    });
	    
	    skipButton.setOnMouseClicked(event -> {
	    	addClickAnimation(skipButton);
		    currentIndex=traversalList.size()-1;	
	    });
	    
	    resetButton.setOnMouseClicked(event -> {
	    	addClickAnimation(resetButton);
		    currentIndex=0;	
		    if(!drawThread.isAlive()) drawTree(traversalList.get(currentIndex));
	    });
    }
	
	AVLTree tree = new AVLTree();
	
//==============================================================================================  
	Image playImage  = new Image("/hedspi/group28/resources/play.png");
    Image pauseImage = new Image("/hedspi/group28/resources/pause.png");
    
    private void setPlayImage() {
    	if(isDrawThreadRunning == false) PauseButton.setImage(playImage);
    	else PauseButton.setImage(pauseImage);
    }
    
 // Hàm dùng để tạm dừng luồng
    private void pauseThread() {
        synchronized (lock) {
            isDrawThreadRunning = false;
            setPlayImage();
        }
    }

    // Hàm dùng để tiếp tục luồng
    private void resumeThread() {
        synchronized (lock) {
            isDrawThreadRunning = true;
            lock.notifyAll(); // Thức tỉnh các luồng đang đợi
            setPlayImage();
        }
    }
    
	private void addClickAnimation(ImageView imageView) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), imageView);
            fadeTransition.setFromValue(1.0); // Starting opacity (fully visible)
            fadeTransition.setToValue(0.5); // Ending opacity (half visible)
            fadeTransition.setAutoReverse(true);
            fadeTransition.setCycleCount(2);
            fadeTransition.play();      
    }
	
//==============================================================================================  	
	
    @FXML
    public void handleInsert() {			// hien thi button 
    	HideButton();
        t10.setVisible(true);
        b20.setVisible(true);
    }
    
    @FXML
    public void handleRemove() {			// hien thi button 
    	HideButton();
        t11.setVisible(true);
        b21.setVisible(true);
    }
    
    @FXML
    public void handleUpdate() {			// hien thi button 
    	HideButton();
        t12.setVisible(true);
        t22.setVisible(true);
        b32.setVisible(true);
    }
    
    @FXML
    public void handleTraverse() {			// hien thi button 
    	HideButton();
    	Algorithms.setVisible(true);       
    }
    
    @FXML
    public void handleSearch() {			// hien thi button 
    	HideButton();
        t14.setVisible(true);
        b24.setVisible(true);
    }
    
    private void HideButton() {
    	Algorithms.setVisible(false); 
    	t10.setVisible(false); 
    	b20.setVisible(false); 
    	t11.setVisible(false); 
    	b21.setVisible(false); 
    	t12.setVisible(false); 
    	t22.setVisible(false); 
    	b32.setVisible(false); 
    	t14.setVisible(false); 
    	b24.setVisible(false); 
    }
    
//==============================================================================================  
    
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
//==============================================================================================  
    private LinkedList<Integer> traversalList = new LinkedList<>();
    private int currentIndex = 0;
    private volatile Thread drawThread;
    private volatile boolean isDrawThreadRunning = false;
    private final Object lock = new Object();
    
    private void traverse() {
        if (traversalList == null || traversalList.isEmpty()) {
            setPlayImage();
            return;
        } else {       
            drawThread = new Thread(() -> {       	
                isDrawThreadRunning = true;
                setPlayImage();
                while (currentIndex < traversalList.size() - 1) {
                    try {
                        Thread.sleep(1000); // Đợi 1 giây
                        // Sử dụng synchronized để đảm bảo đồng bộ hóa
                        synchronized (lock) {
                            while (!isDrawThreadRunning) {
                                lock.wait(); // Đợi nếu luồng bị tạm dừng
                            }
                            Platform.runLater(() -> { 
                                drawTree(traversalList.get(currentIndex));  
                                currentIndex++;
                            });
                        }
                    } catch (InterruptedException e) {                        
                        Thread.currentThread().interrupt();
                    }
                }
                isDrawThreadRunning = false;
                setPlayImage();
            });        
            drawThread.start();            
        }
    }

    private void preOrder() {
        PreOrder preOrder = new PreOrder();
        preOrder.traverse(tree.getRoot());
        traversalList = preOrder.getTraversalList();
        traverse();
    }
    
    private void inOrder() {
        InOrder inOrder = new InOrder();
        inOrder.traverse(tree.getRoot());
        traversalList = inOrder.getTraversalList();
        traverse();
    }
    
    private void postOrder() {
        PostOrder postOrder = new PostOrder();
        postOrder.traverse(tree.getRoot());
        traversalList = postOrder.getTraversalList();
        traverse();
    }
    
    private void levelOrder() {
    	LevelOrder levelOrder = new LevelOrder();
    	levelOrder.traverse(tree.getRoot());
        traversalList = levelOrder.getTraversalList();
        traverse();
    }
      
//==============================================================================================  
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
