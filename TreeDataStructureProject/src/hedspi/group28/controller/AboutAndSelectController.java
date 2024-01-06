package hedspi.group28.controller;

import java.io.IOException;

import hedspi.group28.controller.tree.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AboutAndSelectController {
    
    @FXML private Button About;
    @FXML private ComboBox<String> Select;
    @FXML private Pane TreeView;
    
    @FXML
    private void initialize() {
        // Initialize ComboBox items and select the first item
        Select.getItems().addAll(
        		"Generic tree",
                "A Binary Search Tree (BST)",
                "An Adelson-Velskii Landis (AVL)",
                "Balanced binary tree"
                
        );
        Select.getSelectionModel().selectFirst();
        
        // Set event handler for ComboBox
        Select.setOnAction(e -> {
            String selected = Select.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/MainScene.fxml"));
            switch (selected) {
                case "Generic tree":
                	loader.setController(new GenController());
                	//deleteTreeView();
                    break;
                case "A Binary Search Tree (BST)":
                	loader.setController(new BSTController());
                	//deleteTreeView();
                    break;
                case "An Adelson-Velskii Landis (AVL)":
                	loader.setController(new AVLController());
                	//deleteTreeView();
                    break;
                case "Balanced binary tree":
                	loader.setController(new BSTController());
                	//deleteTreeView();
                    break;
            }
        });
    }
    
    public void deleteTreeView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hedspi/group28/view/MainScene.fxml"));
        try {
            Parent root = loader.load();
            Pane treeViewPane = (Pane) root.lookup("TreeView");

            if (treeViewPane != null) {
                treeViewPane.getChildren().clear();
            } else {
                System.out.println("TreeView Pane not found or null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleAbout() {
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
