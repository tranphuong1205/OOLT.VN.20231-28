package aims;

import java.util.Scanner;

public class aims {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{  
		showMenu();
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. Types of tree");
		System.out.println("2. Help");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	   
		int choice = scanner.nextInt();
		switch (choice){
			case 0: Exit();				// Quit button exits the application
				return;
			case 1: SelectDataType(); 	//select a type of data structure 
				break;
			case 2: ShowHelp(); 		// help menu shows the basic usage and aim of the project
				break;
			default:
		          System.out.println("Choose again!");
		          showMenu();
		}
	}
	
	public static void Exit() {
		//ask for confirmation
		
	}
	
	public static void ShowHelp() {
		
	}

	public static void SelectDataType() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Generic tree (no special properties)");
		System.out.println("2. A Binary Search Tree (BST)");
		System.out.println("3. An Adelson-Velskii Landis (AVL) ");
		System.out.println("4. Balanced binary tree ");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int choice = scanner.nextInt();
		switch (choice){
//			case 0: Exit();				// Quit button exits the application
//				return;
			case 1: G_Tree(); 	//select a type of data structure 
				break;
			case 2: ShowHelp(); 		// help menu shows the basic usage and aim of the project
				break;
			default:
		          System.out.println("Choose again!");
		          showMenu();
		}
	}
	
	
	public static void G_Tree() {
		
	}
		
	
	
	
}


