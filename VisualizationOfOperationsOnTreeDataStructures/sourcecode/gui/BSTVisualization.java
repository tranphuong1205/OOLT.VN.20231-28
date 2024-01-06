package gui;

import algorithm.Algorithm;
import algorithm.InOrder;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tree.BNode;
import tree.BSTree;
import tree.GenericNode;
import tree.GenericTree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTVisualization extends Application {
    public void start(Stage primaryStage){
        BSTree  tree = new BSTree();
        BorderPane pane = new BorderPane();
        BSTPane bstPane = new BSTPane(tree);
        setPane(pane,bstPane, tree);
        setStage(pane, primaryStage, " Binary Search Tree");

    }
    public void setStage(BorderPane pane, Stage primaryStage, String title){
        Scene scene = new Scene(pane, 700, 700);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setPane(BorderPane pane, BSTPane  bstPane, BSTree tree){
        pane.setCenter(bstPane);
        MenuButton menu = new MenuButton("Create");
        javafx.scene.control.MenuItem g = new javafx.scene.control.MenuItem("Generic Tree");
        javafx.scene.control.MenuItem bst = new javafx.scene.control.MenuItem("Binary Search Tree");
        javafx.scene.control.MenuItem avl = new javafx.scene.control.MenuItem("AVL Tree");
        javafx.scene.control.MenuItem bt = new javafx.scene.control.MenuItem(" Balance Tree");

        menu.getItems().addAll(g, bst, avl,bt);

        TextField insertPValue = new TextField();
        TextField insertCValue = new TextField();
        TextField deleteValue = new TextField();
        TextField searchValue = new TextField();


        Button insertCf = new Button("OK");
        Button  deleteCf = new Button("OK");
        Button searchCf = new Button("OK");

        HBox i = new HBox(30);
        i.getChildren().addAll(insertPValue, insertCValue,insertCf);
        i.setVisible(false);
        HBox d = new HBox(5);
        d.getChildren().addAll(deleteCf, deleteValue);
        d.setVisible(false);
        HBox s = new HBox(5);
        s.getChildren().addAll(searchValue, searchCf);
        s.setVisible(false);

        Button insert = new Button("Insert");
        Button  delete = new Button("Delete");
        Button  search = new Button("Search");
        MenuButton traMenu = new MenuButton("traverse");
        MenuItem level = new MenuItem("BFS");
        MenuItem pre = new MenuItem("DFS");


        traMenu.getItems().addAll(level, pre);
        addAlgorithm(insertPValue, insertCValue,deleteValue,searchValue,i,d,s,insertCf,insert,deleteCf,delete,searchCf,search,tree, bstPane, pre, level);


        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(insert,i, delete,d,search,s, traMenu);

        pane.setBottom(hBox);

    }
    public void addAlgorithm(TextField insertPValue ,TextField insertCValue,TextField deleteValue,TextField searchedValue,HBox i, HBox d, HBox s,Button insertCf, Button insert,Button deleteCf, Button delete,Button searchCf, Button search, BSTree tree, BSTPane view, MenuItem preOrder, MenuItem leverOrder){
        insert.setOnAction(e -> {
            i.setVisible(true);
            insertPValue.setVisible(false);
        }
        );
        insertCf.setOnAction(iCfE -> {

            if(insertCValue.getText().isEmpty()  ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You haven't entered anything!", ButtonType.OK);
                alert.getDialogPane().setMinHeight(80);
                alert.show();
            }
            else{
                int key = Integer.parseInt(insertCValue.getText());


                if(tree.search(key) != null){
                    view.displayTree();
                }
                else{
                    tree.insert(0, key);
                    view.displayTree();
                }
            }
            insertCValue.clear();
            insertPValue.clear();
            i.setVisible(false);
        });
        delete.setOnAction(e->{
            d.setVisible(true); });
        deleteCf.setOnAction(dCfE -> {
            int key = Integer.parseInt(deleteValue.getText());
            if(tree.search(key) == null){
                view.displayTree();
            }
            else{
                tree.delete(key);
                view.displayTree();
            }
            deleteValue.clear();
            d.setVisible(false);
        });
        search.setOnAction(e->{
            s.setVisible(true);});
        searchCf.setOnAction(sCfE -> {
            if(searchedValue.getText().isEmpty()  ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You haven't entered anything!", ButtonType.OK);
                alert.getDialogPane().setMinHeight(80);
                alert.show();
            }
            else{
                int key = Integer.parseInt(searchedValue.getText());
                BNode searchedNode = tree.search(key);
                view.searchNode(searchedNode);
                view.displayTree();
            }
            searchedValue.clear();
            s.setVisible(false);
            view.clearSearch();
        });
        preOrder.setOnAction(e -> {
         preOrderUI(tree.getRoot(), view);

        });
        leverOrder.setOnAction(e -> {
            levelOrder(tree.getRoot(), view);
        });
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

    public  void preOrderUI(BNode r, BSTPane pane) {
        if(r == null) return;
        r.setVisited(true);
        pane.displayTree();

        Timeline waitTimeline = new Timeline(new KeyFrame(
                Duration.seconds(2),
                event -> {
                    // Duyệt sang nút con trái
                    preOrderUI(r.getLeft(), pane);
        Timeline waitLeft = new Timeline(new KeyFrame(
                Duration.seconds(2),
                e -> {
                    // Duyệt sang nút phải
                    preOrderUI(r.getRight(), pane);}));
                waitLeft.play();
                }
        ));
        waitTimeline.play();


    }

        public void levelOrder(BNode r, BSTPane pane) {
            if(r == null) return;
            r.setVisited(true);
            pane.displayTree();

            Timeline waitTimeline = new Timeline(new KeyFrame(
                    Duration.seconds(2),
                    event -> {
                        // Duyệt sang nút con trái
                        levelOrder(r.getLeft(), pane);

                        // Duyệt sang nút phải
                        levelOrder(r.getRight(), pane);
                    }
            ));
            waitTimeline.play();
        }



}
