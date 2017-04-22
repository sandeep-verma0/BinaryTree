package com.learnbycoding.binaryTreeExamples;

public class CheckIfGivenTreeIsSumTree {

	// Root of Binary Tree
	Node root;

	CheckIfGivenTreeIsSumTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	
	private int getSum(Node root){
		
		if(root==null)
			return 0;
		
		return  
			getSum(root.left)+ getSum(root.right) + root.data;
		
	}
	private boolean isSumTree(Node root){
		
		if ((root == null) || (root.left == null && root.right == null))
		return true;
		
		int leftSum=0 , rightSum=0;
		leftSum= getSum(root.left);
		rightSum = getSum(root.right);
		
		if(root.data ==rightSum+leftSum && isSumTree(root.left) && isSumTree(root.right))
		  return true;
		
		  return false;
	}
	
	public static void main(String[] args) {

		CheckIfGivenTreeIsSumTree binTree = new CheckIfGivenTreeIsSumTree();
		binTree.root = binTree.new Node(26);
		binTree.root.left = binTree.new Node(10);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(6);
		binTree.root.right.right = binTree.new Node(3);
		
		System.out.println("Is Sum tree --> " + binTree.isSumTree(binTree.root));

	}

}
