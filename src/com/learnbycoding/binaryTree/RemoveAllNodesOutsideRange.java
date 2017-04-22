package com.learnbycoding.binaryTree;

import com.learnbycoding.binaryTree.AddAllGreaterValuesToEveryNodeInBST.Node;

public class RemoveAllNodesOutsideRange {
	Node root;

	RemoveAllNodesOutsideRange() {
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

	private Node removeNodesOutsideRange(Node root, int min, int max) {

		if(root==null)
			return null;
		root.left=removeNodesOutsideRange(root.left, min, max);
		root.right=removeNodesOutsideRange(root.right, min, max);
		
		if(root.data < min || root.data > max){
		//	System.out.println("Min is --> " + min + "  max is --> " + max);
			System.out.println("Node to delete --> " + root.data);
			root = deleteNodeUtil(root, root.data);
		}
		
		return root;
	}

	private Node deleteNodeUtil(Node root, int nodeToDelete) {

		if (root.data < nodeToDelete)
			deleteNodeUtil(root.right, nodeToDelete);

		if (root.data > nodeToDelete)
			deleteNodeUtil(root.left, nodeToDelete);
		else {

			if (root.left == null)
				return root.right;

			if (root.right == null)
				return root.left;

			root.data = findInorderSuccessor(root.right);
			
			root.right = deleteNodeUtil(root.right, root.data);
		}
		
		return root;
	}

	private int findInorderSuccessor(Node root) {
		int tempData = root.data;

		Node curr = root;
		while (curr.left != null) {
			tempData = curr.left.data;
			curr = curr.left;
		}
		return tempData;

	}
	
	private void inOrderTraversal(Node root){
		if(root==null)
			return ;
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	

	public static void main(String[] args) {
		RemoveAllNodesOutsideRange bst = new RemoveAllNodesOutsideRange();
		bst.root = bst.new Node(50);
		bst.root.left = bst.new Node(30);
		bst.root.right = bst.new Node(70);
		bst.root.left.left = bst.new Node(20);
		bst.root.left.right = bst.new Node(40);
		bst.root.right.left = bst.new Node(60);
		bst.root.right.right = bst.new Node(80);
		
		bst.inOrderTraversal(bst.root);
		System.out.println();
		bst.root=bst.removeNodesOutsideRange(bst.root, 50, 75);
		bst.inOrderTraversal(bst.root);

	}
}
