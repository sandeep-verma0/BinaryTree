package com.learnbycoding.binaryTree;

public class FindLargestBSTinBT {
	Node root;

	FindLargestBSTinBT() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	private boolean isBST(Node root, int min, int max) {

		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return (isBST(root.left, min, root.data - 1) && isBST(root.right,
				root.data + 1, max));
	}
	
	private int size(Node root){
		if(root==null)
			return 0;
		
		else 
			return size(root.left)+size(root.right)+1;
	}

	int largestBST(Node root){
		if(isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE))
			return size(root);
		else 
			return Math.max(largestBST(root.left), largestBST(root.right));
	}

	
	private void inOrderTraversal(Node root){
		if(root==null)
			return ;
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	public static void main(String[] args) {

		FindLargestBSTinBT bst = new FindLargestBSTinBT();
		bst.root = bst.new Node(50);
		bst.root.left = bst.new Node(30);
		bst.root.right = bst.new Node(60);
		bst.root.left.left = bst.new Node(5);
		bst.root.left.right = bst.new Node(20);
		bst.root.right.left = bst.new Node(45);
		bst.root.right.right = bst.new Node(70);
		bst.root.right.right.left = bst.new Node(65);
		bst.root.right.right.right = bst.new Node(80);
		
		System.out.println("Inorder traversal of BT is following. ");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println();
		
		System.out.println("Size of largest BST in this tree is.");
		System.out.println(bst.largestBST(bst.root));
	}
}
