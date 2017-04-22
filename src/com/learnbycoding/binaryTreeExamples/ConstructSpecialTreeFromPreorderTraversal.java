package com.learnbycoding.binaryTreeExamples;


public class ConstructSpecialTreeFromPreorderTraversal {

	// Root of Binary Tree
	Node root;

	ConstructSpecialTreeFromPreorderTraversal() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	class Index 
	{
	    int index = 0;
	}
	
	Index myindex = new Index();
	
	Node constructTreeUtil(int pre[], char preLN[], Index index_ptr, int n,
			Node temp) {
		// store the current value of index in pre[]
		int index = index_ptr.index;

		// Base Case: All nodes are constructed
		if (index == n)
			return null;

		// Allocate memory for this node and increment index for
		// subsequent recursive calls
		temp = new Node(pre[index]);
		(index_ptr.index)++;

		// If this is an internal node, construct left and right subtrees
		// and link the subtrees
		if (preLN[index] == 'N') {
			temp.left = constructTreeUtil(pre, preLN, index_ptr, n, temp.left);
			temp.right = constructTreeUtil(pre, preLN, index_ptr, n, temp.right);
		}

		return temp;
	}

	// A wrapper over constructTreeUtil()
	Node constructTree(int pre[], char preLN[], int n, Node node) {
		// Initialize index as 0. Value of index is used in recursion to
		// maintain the current index in pre[] and preLN[] arrays.
		 myindex.index = 0;

		return constructTreeUtil(pre, preLN, myindex, n, node);
	}

	private void printInoderTravesal(Node root) {
		if (root == null)
			return;

		printInoderTravesal(root.left);
		System.out.print(root.data + " ");
		printInoderTravesal(root.right);
	}

	public static void main(String[] args) {
		ConstructSpecialTreeFromPreorderTraversal binTree = new ConstructSpecialTreeFromPreorderTraversal();
		int[] pre = { 10, 30, 20, 5, 15 };
		char[] preLN = { 'N', 'N', 'L', 'L', 'L' };

		//binTree.constructSpecialBTUsingPreOrder(binTree.root, pre, preLN, 0,pre.length - 1);
		
		Node mynode  =binTree.constructTree(pre, preLN, pre.length, binTree.root);
		binTree.printInoderTravesal(mynode);

	}
}
