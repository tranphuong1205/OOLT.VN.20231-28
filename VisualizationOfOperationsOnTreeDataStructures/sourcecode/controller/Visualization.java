package controller;

import gui.AVLVisualization;
import gui.BSTVisualization;
import gui.GenericVisualization;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import gui.BTVisualization;

public class Visualization {
    @FXML
    private Button gt;
    @FXML
    private Button bst;
    @FXML
    private Button avl;
    @FXML
    private Button bt;
    @FXML
    private void gtAction(){
        gt.setOnAction(e-> setStage(new GenericVisualization()));
    }
    @FXML
    private void bstAction(){
        bst.setOnAction(e -> setStage(new BSTVisualization()));
    }
    @FXML
    private void avlAction(){
        avl.setOnAction(e -> setStage(new AVLVisualization()));
    }
    @FXML
    private void btAction(){bt.setOnAction(e-> setStage(new BTVisualization()));}
    private void setStage(GenericVisualization menu){
        Stage menuStage = new Stage();
        menu.start(menuStage);
        menuStage.show();
    }
    private void setStage(BSTVisualization menu){
        Stage menuStage = new Stage();
        menu.start(menuStage);
        menuStage.show();
    }
    private void setStage(AVLVisualization menu){
        Stage menuStage = new Stage();
        menu.start(menuStage);
        menuStage.show();
    }
    private void setStage(BTVisualization menu){
        Stage menuStage = new Stage();
        menu.start(menuStage);
        menuStage.show();
    }
}