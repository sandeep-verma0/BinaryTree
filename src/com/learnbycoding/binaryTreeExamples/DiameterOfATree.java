package com.learnbycoding.binaryTreeExamples;

public class DiameterOfATree {

	// Root of Binary Tree
	Node root;

	DiameterOfATree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	class Height {

		int h;
	}

	private int diameterOfATree(Node root) {

		if (root == null)
			return 0;

		int leftDiameter = diameterOfATree(root.left);
		int rightDiameter = diameterOfATree(root.right);

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight
				+ rightHeight + 1);
	}

	private int optimisedDiameterOfATree(Node root, Height height) {

		if (root == null) {
			height.h = 0;
			return 0;
		}

		Height lh = new Height();
		Height rh = new Height();
		
		lh.h++;
		rh.h++;
		
		int leftDiameter = optimisedDiameterOfATree(root.left , lh);
		int rightDiameter = optimisedDiameterOfATree(root.right , rh);

		height.h = Math.max(lh.h, rh.h)+1;
		

		return Math.max(Math.max(leftDiameter, rightDiameter), lh.h+ rh.h + 1);
	}

	private int height(Node root) {

		if (root == null)
			return 0;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return (Math.max(leftHeight, rightHeight) + 1);
	}

	public static void main(String[] args) {

		DiameterOfATree binTree = new DiameterOfATree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		binTree.root.right.left.left = binTree.new Node(8);

		System.out.println("Diameter of tree is  : "
				+ binTree.diameterOfATree(binTree.root));
		
		System.out.println("Diameter of tree is  : "
				+ binTree.optimisedDiameterOfATree(binTree.root , binTree.new Height()));
	}
}
