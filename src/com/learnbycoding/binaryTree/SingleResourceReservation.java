package com.learnbycoding.binaryTree;


public class SingleResourceReservation {
	// Root of Binary Tree
	Node root;

	SingleResourceReservation() {
		root = null;
	}

	class Node {
		int time;
		Node left, right;

		public Node(int time) {
			this.time = time;
		}
	}

	private Node insert(int currentTime, int time, int k) {

		deleteNode(root, currentTime, k);

		return new Node(0);
	}

	private Node insertHelper(int time, int k) {

		if (root == null) {
			root = new Node(time);
			return root;
		}

		if (time > root.time + k)
			return root;
		
		return root;
	}

	// Delete in Inorder fashion
	private Node deleteNode(Node root, int currentTime, int k) {
		if (root == null)
			return null;

		root.left = deleteNode(root.left, currentTime, k);
		if (root.time + k <= currentTime) {
			root = deleteNodeHelper(root, currentTime, k);
			System.out.println("Deleted node" + root.time);
		}
		root.right = deleteNode(root.right, currentTime, k);

		return root;
	}

	private Node deleteNodeHelper(Node root, int currentTime, int k) {

		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;

		root.time = getInorderSuccessor(root.right);

		root.right = deleteNodeUtil(root, root.time);

		return root;
	}

	private Node deleteNodeUtil(Node root, int data) {

		if (root == null)
			return null;

		if (data < root.time)
			root.left = deleteNodeUtil(root.left, data);
		else if (data > root.time)
			root.right = deleteNodeUtil(root.right, data);
		else {

			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.time = getInorderSuccessor(root.right);
			// Delete the inorder successor
			root.right = deleteNodeUtil(root.right, root.time);
		}

		return root;
	}

	private int getInorderSuccessor(Node root) {
		int min = root.time;
		while (root.left != null) {
			min = root.left.time;
			root = root.left;
		}
		return min;
	}

	public static void main(String[] args) {

	}
}
