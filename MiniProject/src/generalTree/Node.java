package generalTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int value;
    private List<Node> children;
    public int height;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

	public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public void removeChild(Node child) {
        children.remove(child);
    }
    
    public void setChildren(List<Node> children) {
        this.children = children;
    }
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getChildrenCount() {
        return children.size();
    }
    
    public void assignChildren(Node a) {
        // Thêm các node con của Node A vào Node B
    	for (Node child : a.getChildren()){
            this.addChild(child);
        }
    }

}
