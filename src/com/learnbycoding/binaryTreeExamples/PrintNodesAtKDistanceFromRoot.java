package com.learnbycoding.binaryTreeExamples;

public class PrintNodesAtKDistanceFromRoot {
	

	// Root of Binary Tree
	Node root;

	PrintNodesAtKDistanceFromRoot() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	
	private void printNodesAtKDistance(Node root , int k){
		
		if(root==null)
			return ;
		
		if(k==0)
			System.out.print(root.data+" ");
		
		printNodesAtKDistance(root.left, k-1);
		printNodesAtKDistance(root.right, k-1);
	}
public static void main(String[] args) {
	PrintNodesAtKDistanceFromRoot binTree = new PrintNodesAtKDistanceFromRoot();
	binTree.root = binTree.new Node(1);
	binTree.root.left = binTree.new Node(2);
	binTree.root.right = binTree.new Node(3);

	binTree.root.right.left = binTree.new Node(4);
	binTree.root.left.right = binTree.new Node(5);
	binTree.root.left.right.left = binTree.new Node(6);
	binTree.root.right.left.right = binTree.new Node(7);
	binTree.printNodesAtKDistance(binTree.root , 2);
	
}
}
