package test;

import tree.AVLTree;
import algorithm.Algorithm;
import algorithm.PreOrder;


public class TestAlgorithm {
	public static void main(String[] args) {
		AVLTree avlt = new AVLTree();
		avlt.insert(0, 12);
		 avlt.insert(0, 4);
		 avlt.insert(0, 18);
		 avlt.insert(0, 7);
		 avlt.insert(0, 9);
		 Algorithm po = new PreOrder();
		 avlt.traverse(po);
		
		System.out.print(avlt.search(18).getNodeValue());
		
	}
}
