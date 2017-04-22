package com.learnbycoding.binaryTreeExamples;


public class CalculateSizeAndHeightOfTree {
	// Root of Binary Tree
	Node root;

	CalculateSizeAndHeightOfTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private int getSize(Node root) {

		if(root==null)
			return 0;
		
		int leftSize = getSize(root.left);
		int  rightSize = getSize(root.right);
		
		return (leftSize+rightSize+1);

	}

	private int maxHeight(Node root) {
		
		if(root==null)
			return 0;
		
		int leftHeight = getSize(root.left);
		int rightHeight = getSize(root.right);
		
		//return (Math.max(leftHeight,rightHeight)+1);
		
		if(leftHeight>rightHeight)
			return leftHeight+1;
		else 
			return rightHeight+1;

	}

	public static void main(String[] args) {

		CalculateSizeAndHeightOfTree binTree = new CalculateSizeAndHeightOfTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		
		System.out.println("size of tree is : " + binTree.getSize(binTree.root));
		
		System.out.println("height of tree is : " + binTree.maxHeight(binTree.root));

	}

}
