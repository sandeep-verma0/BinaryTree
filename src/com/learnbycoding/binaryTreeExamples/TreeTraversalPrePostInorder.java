package com.learnbycoding.binaryTreeExamples;

public class TreeTraversalPrePostInorder {

	// Root of Binary Tree
	Node root;

	TreeTraversalPrePostInorder() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private void InorderRecursive(Node root) {

		if(root==null)
			return ;
		InorderRecursive(root.left);
		System.out.print(root.data + " ");
		InorderRecursive(root.right);
		
		
	}

	private void preOrderRecursive(Node root) {
		if(root==null)
			return ;
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	private void postOrderRecursive(Node root) {
		
		if(root==null)
			return ;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");

	}

	public static void main(String[] args) {

		TreeTraversalPrePostInorder binTree = new TreeTraversalPrePostInorder();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);
		
		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		
		System.out.println("Pre Order traversal.");
		binTree.preOrderRecursive(binTree.root);
		System.out.println();
		
		System.out.println("Inorder Order traversal.");
		binTree.InorderRecursive(binTree.root);
		System.out.println();
		
		System.out.println("Post Order traversal.");
		binTree.postOrderRecursive(binTree.root);
		System.out.println();
	}
}
