package test;

import algorithm.PreOrder;
//import tree.AVLTree;
import tree.GenericTree;
//import tree.BSTree;



public class TestAlgorithm {
	public static void main(String[] args) {
		/*BSTree bst = new BSTree();
		bst.insert(0, 12);
		 bst.insert(0, 4);
		 bst.insert(0, 18);
		 bst.insert(0, 7);
		 bst.insert(0, 9);
		PreOrder po = new PreOrder();
        bst.traverse(po);*/
		/*AVLTree avlt = new AVLTree();
		avlt.insert(0, 12);
		 avlt.insert(0, 4);
		 avlt.insert(0, 18);
		 avlt.insert(0, 7);
		 avlt.insert(0, 9);
		 PreOrder po = new PreOrder();
		 avlt.traverse(po);*/
		GenericTree bt = new GenericTree();
		bt.insert(1, 12);
		 bt.insert(12, 4);
		 bt.insert(4, 18);
		 bt.insert(12, 7);
		 bt.insert(7, 9); 
		 bt.insert(7, 30);
		 PreOrder po = new PreOrder();
		 bt.traverse(po);
		
	}
}
