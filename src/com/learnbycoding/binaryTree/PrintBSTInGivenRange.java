package com.learnbycoding.binaryTree;

public class PrintBSTInGivenRange {

	private void printBSTElementsInGivenRange(InsertDeleteSearchBST.Node root , int k1 , int k2){
		
		
		if(root==null)
			return ;
		
	    printBSTElementsInGivenRange(root.left, k1, k2);
	    
	    if(root.data >=k1 &&  root.data <=k2)
	    	System.out.print(root.data+ " ");
	    printBSTElementsInGivenRange(root.right, k1, k2);
	}
	
	
	public static void main(String[] args) {

		PrintBSTInGivenRange elementInbst = new PrintBSTInGivenRange();
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		InsertDeleteSearchBST.Node root = bst.getRoot();
		
		System.out.println("Print element in the the range of 21 and 79.");
		elementInbst.printBSTElementsInGivenRange(root, 21, 79);
	}

}
