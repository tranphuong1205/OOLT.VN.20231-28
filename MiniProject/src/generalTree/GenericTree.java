package generalTree;

public class GenericTree{
	public Node rootNode;
		
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	//************************************************************
	//                  SEARCH NODE
	//************************************************************
    public Node search(int value) {
        return searchRecursive(rootNode, value);
    }

    // Hàm đệ quy để tìm kiếm giá trị trong cây
    private Node searchRecursive(Node node, int value) {
        if (node == null || node.getValue() == value) {
            return node;
    }  
        // Duyệt qua các nút con để tìm kiếm giá trị
        for (Node child : node.getChildren()) {
            Node found = searchRecursive(child, value);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
    
    //************************************************************
  	//                  UPDATE NODE
  	//************************************************************
    // hàm cập nhật giá trị của node 
    public void updateNode(int currentValue, int newValue) {
        Node nodeToUpdate = search(currentValue);
        if (nodeToUpdate != null) {
            nodeToUpdate.setValue(newValue);
        } else {
            System.out.println("Node with value " + currentValue + " not found.");
        }
    }

    //************************************************************
  	//                  DELETE NODE
  	//************************************************************
    // Hàm xóa node 
    public void deleteNode(int value) {
        Node nodeToDelete = search(value);
        if (nodeToDelete != null) {
            // Xóa nút khỏi danh sách nút con của nút cha (nếu có)
            Node parent = findParent(rootNode, value);	// Tìm kiếm nút cha 
            if (parent != null) {
                parent.getChildren().remove(nodeToDelete);
                	parent.assignChildren(nodeToDelete);	// gán tất cả các con của nodeToDelete cho parent
            } else {
                rootNode = null; // Nếu nút cần xóa là nút gốc, gán rootNode thành null
            }
        } else {
            System.out.println("Node with value " + value + " not found.");
        }
    }

    // Hàm tìm cha của một nút trong cây (để xóa nút)
    private Node findParent(Node node, int value) {
        for (Node child : node.getChildren()) {
            if (child.getValue() == value) {
                return node;
            } else {
                Node parent = findParent(child, value);
                if (parent != null) {
                    return parent;
                }
            }
        }
        return null;
    }
       
	//************************************************************
	//                  INSERT NODE
	//************************************************************
    // Hàm thêm node có giá trị childValue làm con node có giá trị parentValue
    public void insertNode(int parentValue, int childValue) {
        Node parentNode = search(parentValue); // Tìm nút cha dựa trên giá trị
        Node checkChild = search(childValue); // Kiểm tra xem childValue đã tồn tại hay chưa 

        if (parentNode == null) {
            System.out.println("Parent node with value " + parentValue + " not found.");
        } else if (checkChild != null) {
            System.out.println("Child node with value " + childValue + " already exists.");
        } else {
            Node childNode = new Node(childValue); // Tạo một nút mới với giá trị childValue
            parentNode.addChild(childNode); // Thêm nút con vào nút cha
        }
    }
}
