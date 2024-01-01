package test;

import tree.BSTree;



public class TestAlgorithm {
	public static void main(String[] args) {
		BSTree bst = new BSTree();
		bst.insert(0, 12);
		 bst.insert(0, 4);
		 bst.insert(0, 18);
		 bst.insert(0, 7);
		 bst.insert(0, 9);
		
		System.out.print(bst.search(18).getNodeValue());
		
	}
}
