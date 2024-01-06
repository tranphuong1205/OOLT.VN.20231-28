package hedspi.group28.test;

import hedspi.group28.model.tree.BSTree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private TreeController treeController = new TreeController();
    private Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Tree Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();

        	BSTree bt = new BSTree();
        	bt.insert(1, 12);
        	 bt.insert(12, 4);
        	 bt.insert(4, 5);
        	 bt.insert(12, 23);
        	 bt.insert(7, 3); 
        	 bt.insert(7, 30);

        // Draw the tree initially
        treeController.drawTree(bt.getRoot(), pane, 400, 50, 1);

        // Example of inserting a new node
        //treeController.insertNode(rootNode, 6, pane, 400, 50, 1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

