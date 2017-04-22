package com.learnbycoding.binaryTreeExamples;

public class InorderTraversalUsingThreads {

	// Root of Binary Tree
	Node root;

	InorderTraversalUsingThreads() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;
		boolean rightThread;

		public Node(int data) {
			this.data = data;
		}
	}
	// Java code to do inorder traversal in a threaded binary tree
	void inOrder(Node root)
	{
	    Node cur = leftMost(root);
	    while (cur != null)
	    {
	        System.out.print(cur.data + " ");
	        // If this node is a thread node, then go to
	        // inorder successor
	        if (cur.rightThread)
	            cur = cur.right;
	        else // Else go to the leftmost child in right subtree
	            cur = leftMost(cur.right);
	    }
	}

	// Utility function to find leftmost node in atree rooted with n
	private Node leftMost(Node n) {
		if (n == null)
			return null;
		while (n.left != null)
			n = n.left;

		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
