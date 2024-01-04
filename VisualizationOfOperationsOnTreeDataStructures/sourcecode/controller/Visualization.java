package controller;

import gui.BSTVisualization;
import gui.GenericVisualization;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Visualization {
    @FXML
    private Button gt;
    @FXML
    private Button bst;
    @FXML
    private void gtAction(){
        gt.setOnAction(e-> setStage(new GenericVisualization()));
    }
    @FXML
    private void bstAction(){
        bst.setOnAction(e -> setStage(new BSTVisualization()));
    }
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
}