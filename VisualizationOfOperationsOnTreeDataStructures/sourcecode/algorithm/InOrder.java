package algorithm;
import gui.BSTPane;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tree.BNode;
import tree.GenericNode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public  class InOrder implements Algorithm{

	 public void traverse(BNode root) {
		 if(root == null) {
				return;}

			traverse(root.getLeft());
			System.out.print(root.getNodeValue() + "-> ");
		 PauseTransition pause = new PauseTransition(Duration.seconds(2));
		 pause.setOnFinished(e -> {root.setVisited( true);});

			traverse(root.getRight());
	 }
	 public void traverse( GenericNode node) {
		 if(node == null) return ;
		 GenericNode p = node.getLeftMostChild();
		 traverse(p);
		 System.out.print(node.getNodeValue() + " ");
		 if(p != null)
			 p = p.getRightSibling();
		 while(p != null) {
			 traverse(p);
			 p = p.getRightSibling();
		 }
	 }



	public Group findGroup(int k, Pane pane){
		for(Node node : pane.getChildren()){
			if(node instanceof Group){
				for(Node gC : ((Group) node).getChildren()){
					if(gC instanceof Text text && text.getText().equals(String.valueOf(k)) )
						return (Group) node;
				}
			}
		}
		return null;
	}

	public void highlightNode(int k, Pane pane){
		Group gr = findGroup(k, pane);
		if(gr == null) return;
		for(Node node : gr.getChildren()){
			if(node instanceof Circle)
				((Circle) node).setFill(Color.GREEN);
		}
	}

	
}
