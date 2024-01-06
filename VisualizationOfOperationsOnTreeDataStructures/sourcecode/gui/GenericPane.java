package gui;

import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tree.GenericNode;
import tree.GenericTree;


public class GenericPane extends Pane {
    private GenericTree tree;
    private double radius = 15;
    private double vGap = 50;

    private GenericNode searchedNode;

    public GenericPane(GenericTree tree) {
        this.tree = tree;
        setBackground(new Background(new BackgroundFill(Color.web("#444444"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void displayTree() {
        this.getChildren().clear();
        if (tree.getRoot() != null) {
            double temp = getWidth()/4;
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4,temp, Color.MEDIUMPURPLE);
        }
    }

    private void displayTree(GenericNode root, double x, double y, double hGap,double a, Color color) {
        if (root.getLeftMostChild() != null) {
            int d = depth(tree.getRoot(), root.getLeftMostChild().getNodeValue());
            int s = sibling(root.getLeftMostChild()) +1 ;
            System.out.println("x-hgap" + (x - hGap));
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree(root.getLeftMostChild(), x - hGap, y + vGap, hGap/s, a,color);}

        GenericNode h = root.getLeftMostChild();
        while (h != null &&  h.getRightSibling() != null) {
            int d = depth(tree.getRoot(), h.getNodeValue()) ;
            int s = sibling(h) ;

           for(int i = 1; i <= s; i++){

               double b = x - hGap + (i*2*hGap)/s;
           // double b = a*(1+ (double) 2*i/s) ;
            System.out.println( "b "+b);
            getChildren().add(new Line(b , y + vGap, x,y));
            displayTree(h.getRightSibling(),b ,y + vGap,hGap/s,b- (hGap/(2*d)),color);
            h = h.getRightSibling();
           }
        }


            Circle circle = new Circle(x, y, radius);
            circle.setFill(root == searchedNode ? Color.RED : color);
            if (root.getVisited()) {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                circle.setFill(color);
                root.setVisited(false);
            });
            circle.setFill(Color.GREEN );
            pause.play();
            }
            circle.setStroke(Color.BLACK);
            getChildren().addAll(circle, new Text(x - 4, y + 4, root.getNodeValue() + " "));

    }


    private int depth(GenericNode r, int v, int d){
        if(r == null) return -1;
        if(r.getNodeValue() == v) return  d;
        GenericNode p = r.getLeftMostChild();
        while (p != null){
            if(p.getNodeValue() == v) return  d+1;
            int dv = depth(p, v, d+1);
            if(dv > 0 ) return  dv;
            p = p.getRightSibling();
        }
        return  -1;
    }
    public int  depth(GenericNode r, int v){
        return depth(r, v,1);
    }

    private int sibling(GenericNode node){
        int s = 0;
        while (node.getRightSibling() != null) {
            s += 1;
            node = node.getRightSibling();
        }
        return s;
    }
    public void searchNode(GenericNode searchedNode) {
        this.searchedNode = searchedNode;
    }

    public void clearSearch() {
        this.searchedNode = null;
    }

}
