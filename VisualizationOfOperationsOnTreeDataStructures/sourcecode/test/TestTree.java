package test;


import tree.GenericTree;

public class TestTree {
	public static void main(String[] args) {
	GenericTree bt = new GenericTree();
	bt.insert(1, 12);
	 bt.insert(12, 4);
	 bt.insert(4, 18);
	 bt.insert(12, 7);
	 bt.insert(7, 9); 
	 bt.insert(7, 30);
	// bt.update(9, 6);
	 
	 bt.delete(7);
	 System.out.print(bt.search(9).getNodeValue());
	 System.out.print(bt.getRoot().getLeftMostChild().getRightSibling().getNodeValue());
	
	 
}}
