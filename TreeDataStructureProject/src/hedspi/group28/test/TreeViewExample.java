package hedspi.group28.test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeItem<String> rootItem = new TreeItem<>("Root");

        TreeItem<String> item1 = new TreeItem<>("Item 1");
        TreeItem<String> item2 = new TreeItem<>("Item 2");
        TreeItem<String> item3 = new TreeItem<>("Item 3");

        rootItem.getChildren().addAll(item1, item2, item3);

        TreeView<String> treeView = new TreeView<>(rootItem);

        primaryStage.setScene(new Scene(treeView, 300, 200));
        primaryStage.setTitle("TreeView Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
