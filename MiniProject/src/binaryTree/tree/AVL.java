package binaryTree.tree;

import binaryTree.Node;

public class AVL extends Tree {
    
    //************************************************************
  	//                  DELETE NODE
  	//************************************************************
    @Override
    public void deleteNode(int value) {
        // Triển khai xóa nút từ cây AVL
    } 
    
    
    //************************************************************
  	//                  INSERT NODE
  	//************************************************************
    @Override
    public Node insert(Node node, int Value) {
    	if (node == null) return new Node(Value);
    	if (Value < node.value) 
            node.setLeftChild(insert(node.getLeftChild(), Value));
    	else if (Value > node.value) 
            node.setRightChild(insert(node.getRightChild(), Value));  
    	// set height
    	node.height = 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
    
        //Rotate
         int valBalance = getHeight(node.leftChild) - getHeight(node.rightChild); 
         // 4 TH:
         // Left Left
         if(valBalance >1 && Value < (node.leftChild).value) 
        	 return rightRotate(node);        	 
      // Right Right 
         if(valBalance <-1 && Value > (node.rightChild).value)
        	 return leftRotate(node);
      // Left Right 
         if(valBalance > 1 && Value > (node.leftChild).value){
        	 node.setLeftChild(leftRotate(node.leftChild));
        	 //node.leftChild=leftRotate(node.leftChild);
        	 return rightRotate(node);
         }
      // Right Left 
         if(valBalance <-1 && Value < (node.rightChild).value){
        	 node.setRightChild(rightRotate(node.rightChild));
        	 //node.rightChild=rightRotate(node.rightChild);
        	 return leftRotate(node);
         }
         this.rootNode=node;
         return node;
    }

    public int getHeight(Node node) {
    	if(node==null) return 0;  	
    	return node.height;
    }
    
    Node rightRotate(Node y) {
        Node x = y.leftChild;
        Node T = x.rightChild;
        // Bắt đầu quay phải 
        x.rightChild = y;
        y.leftChild = T;
        // Thiết lập chiều cao 
        y.height= 1 + Math.max(getHeight(y.leftChild), getHeight(y.rightChild));
        x.height= 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
        return x;
    }

    Node leftRotate(Node x) {
    	Node y = x.rightChild;
    	Node T = y.leftChild;
        // Bắt đầu quay trái
    	y.leftChild = x;
        x.rightChild  = T;
        
        // Thiết lập chiều cao 
        x.height= 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
        y.height= 1 + Math.max(getHeight(y.leftChild), getHeight(y.rightChild));
        return y;
    }
}

