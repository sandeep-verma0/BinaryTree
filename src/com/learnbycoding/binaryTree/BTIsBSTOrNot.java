package com.learnbycoding.binaryTree;

public class BTIsBSTOrNot {

	public boolean isBST(InsertDeleteSearchBST.Node root , int min , int max){
		
		if(root==null)
			return true;

		if(root.data < min || root.data > max)
		return false;
		
		return (isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max));
	}
	
	public static void main(String[] args) {
		
		BTIsBSTOrNot isBstOrNot = new BTIsBSTOrNot();
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		InsertDeleteSearchBST.Node root = bst.getRoot();
		
		System.out.println("Is this BT tree a BST --> " + isBstOrNot.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		
		InsertDeleteSearchBST bst1 = new InsertDeleteSearchBST();
	
		InsertDeleteSearchBST.Node root1 = bst.getRoot();
		
		root1=bst1.new Node(3);
		root1.left=bst1.new Node(2);
		root1.right=bst1.new Node(5);
		root1.left.left=bst1.new Node(1);
		root1.left.right=bst1.new Node(4);
		
		System.out.println("Is this BT tree a BST --> " + isBstOrNot.isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));	
	}
}
