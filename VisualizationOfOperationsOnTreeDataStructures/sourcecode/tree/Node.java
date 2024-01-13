package tree;

public class Node {
	private int value;
	private boolean isVisited;
	private Node back;
	
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

	public Node getBack() {
		return back;
	}
	
	public void setBack(Node back) {
		this.back = back;
	}
	
	public void updateBack(Node parent) {
		if (parent != null) {
		  back = parent;
		}
	}
}
