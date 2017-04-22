package com.learnbycoding.binaryTreeExamples;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraverseIteraAndRecursive {

	// Root of Binary Tree
	Node root;

	LevelOrderTraverseIteraAndRecursive() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	/*
	  Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n 
	   is the number of nodes in the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1)
	   which is O(n^2).

	 */
	private void printLevelOrderRecursive(Node root) {

		System.out.println("Level order traversal using Recursive approach.");
		
		for (int i = 1; i <= getHeightOfTree(root); i++) {
			printNodeOnALevel(root, i);
			System.out.println();
		}
	}

	private void printNodeOnALevel(Node root, int level) {

		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else {
			printNodeOnALevel(root.left, level - 1);
			printNodeOnALevel(root.right, level - 1);
		}
	}

	private int getHeightOfTree(Node root) {

		if (root == null)
			return 0;

		int leftHeight = getHeightOfTree(root.left);
		int rightHeight = getHeightOfTree(root.right);

		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	/*
	  Time Complexity: O(n) where n is number of nodes in the binary tree
	 */
	private void printLevelOrderIterative(Node root) {

		Deque<Node> queue = new LinkedList<Node>();

		queue.add(root);
		List<Integer> res = new ArrayList<Integer>();
		System.out.println();
		System.out.println("Level order traversal using iterative approach.");
		while (!queue.isEmpty()) {
			int count = queue.size();

		
			while (count > 0) {
				Node current = queue.pop();
				res.add(current.data);
				
				if (current.left != null)
					queue.add(current.left);

				if (current.right != null)
					queue.add(current.right);

				System.out.print(current.data + " ");
				count--;
			}
			System.out.println();
		}

		//res.forEach(System.out::print);
	}

	public static void main(String[] args) {
		LevelOrderTraverseIteraAndRecursive binTree = new LevelOrderTraverseIteraAndRecursive();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);

		binTree.printLevelOrderRecursive(binTree.root);

		binTree.printLevelOrderIterative(binTree.root);
	}

}
