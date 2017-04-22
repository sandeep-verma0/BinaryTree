package com.learnbycoding.binaryTree;


public class AddAllGreaterValuesToEveryNodeInBST {
	Node root;

	AddAllGreaterValuesToEveryNodeInBST() {
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

	class Sum{
		int sum=0;
	}
	
	private void addAllGreaterValuesToEveryNodeInBST(Node root, Sum sum) {

		if (root == null)
			return;

		addAllGreaterValuesToEveryNodeInBST(root.right, sum);
		//System.out.println("root.data is --> " + root.data + " .sum is -->" + sum.sum);
		sum.sum = sum.sum + root.data;
		root.data = sum.sum;	
		
		addAllGreaterValuesToEveryNodeInBST(root.left, sum);
		
	}


	private void inOrderTraversal(Node root){
		if(root==null)
			return ;
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	
	
	public static void main(String[] args) {
		AddAllGreaterValuesToEveryNodeInBST bst = new AddAllGreaterValuesToEveryNodeInBST();
		bst.root = bst.new Node(50);
		bst.root.left = bst.new Node(30);
		bst.root.right = bst.new Node(70);
		bst.root.left.left = bst.new Node(20);
		bst.root.left.right = bst.new Node(40);
		bst.root.right.left = bst.new Node(60);
		bst.root.right.right = bst.new Node(80);
		
		
		System.out.println("Inorder travesal without changes.");

		bst.inOrderTraversal(bst.root);
		System.out.println();
		
		bst.addAllGreaterValuesToEveryNodeInBST(bst.root ,bst.new Sum());
		System.out.println("Inorder travesal After changes.");
		bst.inOrderTraversal(bst.root);
	}

}
