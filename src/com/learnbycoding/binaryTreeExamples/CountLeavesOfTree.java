package com.learnbycoding.binaryTreeExamples;

public class CountLeavesOfTree {

	// Root of Binary Tree
	Node root;

	CountLeavesOfTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private int countLeaves(Node root , int count){
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
			return 1;
		
		int leftCount = countLeaves(root.left, count);
		int rightCount = countLeaves(root.right,count);
		
		return leftCount+rightCount;
		
	}

	public static void main(String[] args) {
		CountLeavesOfTree binTree = new CountLeavesOfTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(7);
		binTree.root.right.left = binTree.new Node(6);
		
		System.out.print("Number of leaves are --> ");
		System.out.print(" " +binTree.countLeaves(binTree.root, 0));

	}

}
