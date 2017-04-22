package com.learnbycoding.binaryTreeExamples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	// Root of Binary Tree
	Node root;

	ConnectNodesAtSameLevel() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;
		int level;
		Node nextRight;

		public Node(int data) {
			this.data = data;
		}
	}

	private void connectNodeAtSameLevel(Node root) {

		int level = 0;
		Queue<Node> queue = new LinkedList<Node>();
		root.level = level;
		queue.add(root);

		while (!queue.isEmpty()) {

			Node curr = queue.poll();
			Iterator<Node> itr = queue.iterator();
            Node iterable= curr;
			while (itr.hasNext()) {
				Node temp = itr.next();
				if (iterable.nextRight == null && temp.level==iterable.level) {
					//System.out.println( "Curr node is --> " + iterable.data + ".next node is --> " + temp.data);
					iterable.nextRight = temp;
					iterable = temp;
					continue;
				}
			}
				if (curr.left != null) {
					//System.out.println("current is --> " + curr.data + " .current.left is --> " + curr.left.data);
					curr.left.level = curr.level + 1;
					queue.add(curr.left);
				}

				if (curr.right != null) {
					curr.right.level = curr.level + 1;
					queue.add(curr.right);
				}
			}
		}
	

	public static void main(String[] args) {
		ConnectNodesAtSameLevel binTree = new ConnectNodesAtSameLevel();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);

		binTree.connectNodeAtSameLevel(binTree.root);
		//binTree.printLevelOfAllNodes(binTree.root);
		
		System.out.println("Following are populated nextRight pointers in "
				+ "the tree" + "(-1 is printed if there is no nextRight)");

		int a = binTree.root.nextRight != null ? binTree.root.nextRight.data
				: -1;
		System.out.println("nextRight of " + binTree.root.data + " is " + a);
		int b = binTree.root.left.nextRight != null ? binTree.root.left.nextRight.data
				: -1;
		System.out.println("nextRight of " + binTree.root.left.data + " is "
				+ b);
		int c = binTree.root.right.nextRight != null ? binTree.root.right.nextRight.data
				: -1;
		System.out.println("nextRight of " + binTree.root.right.data + " is "
				+ c);
		int d = binTree.root.left.left.nextRight != null ? binTree.root.left.left.nextRight.data
				: -1;
		System.out.println("nextRight of " + binTree.root.left.left.data
				+ " is " + d);
		
		int e = binTree.root.right.left.nextRight != null ? binTree.root.right.left.nextRight.data
				: -1;
		System.out.println("nextRight of " + binTree.root.right.left.data
				+ " is " + e);
	}

}
