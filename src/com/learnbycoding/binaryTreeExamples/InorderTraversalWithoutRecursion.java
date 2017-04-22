package com.learnbycoding.binaryTreeExamples;

import java.util.Stack;

public class InorderTraversalWithoutRecursion {

	// Root of Binary Tree
	Node root;

	InorderTraversalWithoutRecursion() {
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
	 1) Create an empty stack S.
	 
	 2) Initialize current node as root
	 
	 3) Push the current node to S and set current = current->left until current is NULL
	 
	 4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
     
     5) If current is NULL and stack is empty then we are done.
     
	 */
	public void inorderTraversal(Node root) {

		 Stack<Node> stack = new Stack<Node>();
		 //Queue<Node> res = new LinkedList<Node>();
		Node current =root;
		
		 //first node to be visited will be the left one
		while (current!= null) {
			stack.add(current);
			current = current.left;
		}
		
		// traverse the tree
		while (!stack.isEmpty()) {
			
			//visit the top node
			Node curr= stack.pop();
			System.out.println(curr.data);
			
			if(curr.right!=null){
				 curr = curr.right;
                 	 while (curr != null) {
	                	stack.add(curr);
	                	curr = curr.left;
	                }
			}

		}

	}

	public static void main(String[] args) {
		InorderTraversalWithoutRecursion binTree = new InorderTraversalWithoutRecursion();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);

		binTree.inorderTraversal(binTree.root);
	}
}
