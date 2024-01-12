package hedspi.group28.controller;

import java.io.IOException;
import hedspi.group28.controller.tree.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class AboutAndSelectController {
    
    @FXML private Button About;
    @FXML private ComboBox<String> Select;
    //@FXML private Pane TreeView;
    
    @FXML
    private void initialize() {
        // Initialize ComboBox items and select the first item
        Select.getItems().addAll(
        		"Generic tree",
                "A Binary Search Tree (BST)",
                "An Adelson-Velskii Landis (AVL)",
                "Balanced binary tree"  
        );
              
        // Set event handler for Select
        Select.setOnAction(e -> {
            String selected = Select.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/MainScene.fxml"));
            switch (selected) {
                case "Generic tree":             	
                	loader.setController(new GenController());
                	deleteTreeView(loader);                	
                    break;
                case "A Binary Search Tree (BST)":
                	loader.setController(new BSTController());               	
                	deleteTreeView(loader);
                    break;
                case "An Adelson-Velskii Landis (AVL)":
                	loader.setController(new AVLController());               	
                	deleteTreeView(loader);
                    break;
                case "Balanced binary tree":
                	loader.setController(new BSTController());              	
                	deleteTreeView(loader);
                    break;
            }
        });                        
    }
    
    public void deleteTreeView(FXMLLoader loader) {
    	Stage stage = (Stage) About.getScene().getWindow();
        try {
        	Parent root = loader.load();
        	Scene scene = new Scene(root);
        	stage.setScene(scene);
        	stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private synchronized void handleAbout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/about.fxml"));
            Parent root = loader.load();
            Stage aboutStage = new Stage();
            aboutStage.setScene(new Scene(root));
            aboutStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
