package com.learnbycoding.binaryTreeExamples;

import java.util.ArrayList;

public class PrintAllRootToLeafNodes {

	// Root of Binary Tree
	Node root;

	PrintAllRootToLeafNodes() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
		
		if(root==null)
			return ;
		
		path.add(root.data);

		if (root.left == null && root.right == null) {
			printList(path);
			return;
		}
		
		printRootToLeafPaths(root.left, new ArrayList<Integer>(path));
		printRootToLeafPaths(root.right, new ArrayList<Integer>(path));
	}

	private void printList(ArrayList<Integer> path) {
		for (Integer i : path) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PrintAllRootToLeafNodes binTree = new PrintAllRootToLeafNodes();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		
		binTree.printRootToLeafPaths(binTree.root, new ArrayList<Integer>());
	}
}
