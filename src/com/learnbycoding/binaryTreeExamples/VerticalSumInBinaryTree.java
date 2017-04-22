package com.learnbycoding.binaryTreeExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class VerticalSumInBinaryTree {
	// Root of Binary Tree
	Node root;

	VerticalSumInBinaryTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;
		int horizotalDistace;

		public Node(int data) {
			this.data = data;
		}
	}

	private void printSumOfAllVerticalNodes(Node root) {
		if (root == null)
			return;
		HashMap<Integer, Integer> mapOfHDAndVerticalSum = new HashMap<Integer, Integer>();
		addHorizontalDistancesOfAllNodes(root, mapOfHDAndVerticalSum, 0);

		Set<Integer> hdSet = mapOfHDAndVerticalSum.keySet();
		List<Integer> list = new ArrayList<Integer>(hdSet);
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return Integer.compare(x, y);
			}
		});

		list.forEach(x -> System.out.println("hd is -> " + x + " .sum is -->  "
				+ mapOfHDAndVerticalSum.get(x)));
	}

	private void addHorizontalDistancesOfAllNodes(Node root,
			HashMap<Integer, Integer> map, int dist) {
		if (root == null)
			return;

		if (map.containsKey(dist)) {
			int previousSum = map.get(dist);
			map.put(dist, previousSum + root.data);
		} else {
			map.put(dist, root.data);
		}

		addHorizontalDistancesOfAllNodes(root.left, map, dist - 1);
		addHorizontalDistancesOfAllNodes(root.right, map, dist + 1);

	}

	public static void main(String[] args) {

		VerticalSumInBinaryTree binTree = new VerticalSumInBinaryTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.left = binTree.new Node(6);
		binTree.root.right.right = binTree.new Node(7);

		binTree.printSumOfAllVerticalNodes(binTree.root);

	}

}
