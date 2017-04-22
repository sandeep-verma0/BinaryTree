package com.learnbycoding.binaryTreeExamples;

public class DeleteABinaryTree {
	// Root of Binary Tree
	Node root;

	DeleteABinaryTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	// Use postorder traversal to delete
	private void deleteATree(Node root) {

		if (root == null)
			return;
		deleteATree(root.left);
		deleteATree(root.right);
		System.out.println("deleted root --> " + root.data);
		root = null;
	}
	
	
	public static void main(String[] args) {
		DeleteABinaryTree binTree = new DeleteABinaryTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);

		System.out.println("Deleteing all nodes of tree using post order travesal");
		binTree.deleteATree(binTree.root);
		
		binTree.root=null;

	}

}
