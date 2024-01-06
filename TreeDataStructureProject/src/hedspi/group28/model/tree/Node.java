package hedspi.group28.model.tree;

public class Node {
	private int value;
	private boolean isVisited ;

	public Node(int x) {
		this.value = x;
		this.isVisited = false;
	}

	public void setVisited(boolean visited) {
		isVisited = visited;
	}
	public boolean getVisited(){
		return  isVisited;
	}

	public int getNodeValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
