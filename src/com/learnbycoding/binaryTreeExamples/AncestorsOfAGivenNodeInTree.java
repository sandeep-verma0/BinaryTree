package com.learnbycoding.binaryTreeExamples;

import java.util.ArrayList;
import java.util.Collections;

public class AncestorsOfAGivenNodeInTree {

	// Root of Binary Tree
	Node root;

	AncestorsOfAGivenNodeInTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private void printAncestorOfANode(Node root, ArrayList<Integer> path,
			int data) {

		if (root == null)
			return;

		if (root.data == data)
			printAll(path);

		path.add(root.data);

		printAncestorOfANode(root.left, new ArrayList<Integer>(path), data);

		printAncestorOfANode(root.right, new ArrayList<Integer>(path), data);

	}

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	boolean printAncestors(Node node, int target) {
		/* base cases */
		if (node == null)
			return false;

		if (node.data == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node,
		 * then print this node
		 */
		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
			return true;
		}

		/* Else return false */
		return false;
	}

	private void printAll(ArrayList<Integer> path) {

		Collections.reverse(path);
		path.forEach(x -> System.out.print(x + " "));
	}

	public static void main(String[] args) {

		AncestorsOfAGivenNodeInTree binTree = new AncestorsOfAGivenNodeInTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.right.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.left.right.left = binTree.new Node(6);
		binTree.root.right.left.right = binTree.new Node(7);

		System.out.println("Childs of node 6 are following.");
		binTree.printAncestorOfANode(binTree.root, new ArrayList<Integer>(), 6);
		System.out.println();
		binTree.printAncestors(binTree.root, 6);

	}

}
