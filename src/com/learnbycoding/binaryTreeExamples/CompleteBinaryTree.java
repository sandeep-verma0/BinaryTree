package com.learnbycoding.binaryTreeExamples;

public class CompleteBinaryTree {
	// Root of Binary Tree
	Node root;

	CompleteBinaryTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	private boolean isCompleteBinaryTree(Node root){
		if(root==null)
			return true;
		
		if(root.left==null && root.right!=null)
			return false;
		
		return isCompleteBinaryTree(root.left) && isCompleteBinaryTree(root.right);
	}

	public static void main(String[] args) {

		CompleteBinaryTree binTree = new CompleteBinaryTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);
		

		binTree.root.left.right = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.left = binTree.new Node(6);
		
		//binTree.root.left.right = binTree.new Node(5);
		//binTree.root.left.right.left = binTree.new Node(6);
		//binTree.root.right.left.right = binTree.new Node(7);
		
		System.out.println("Is tree a complete binary tree --> " +binTree.isCompleteBinaryTree(binTree.root));
	}
}
