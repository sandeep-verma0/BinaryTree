package com.learnbycoding.binaryTreeExamples;

public class ConvertTreeToItsSumTree {
	// Root of Binary Tree
	Node root;

	ConvertTreeToItsSumTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	
	private int convertTreeToSumTree(Node root){
		
		if(root==null)
			return 0 ;
		//Leaf Node , store data in temp ,  reset value to zero and return previous value
		
		int leftValue = convertTreeToSumTree(root.left);
		int rightValue = convertTreeToSumTree(root.right);
		
		int temp=root.data;
		root.data= leftValue+rightValue;
		
		return root.data+temp;
	}
	
	private void inorderTravesal(Node root){
		if(root==null)
			return ;
		inorderTravesal(root.left);
		System.out.print(root.data+" ");
		inorderTravesal(root.right);
		
	}
	
	public static void main(String[] args) {

		ConvertTreeToItsSumTree binTree = new ConvertTreeToItsSumTree();
		binTree.root = binTree.new Node(10);
		binTree.root.left = binTree.new Node(-2);
		binTree.root.right = binTree.new Node(6);

		binTree.root.left.left = binTree.new Node(8);
		binTree.root.left.right = binTree.new Node(-4);
		binTree.root.right.right = binTree.new Node(5);
		binTree.root.right.left = binTree.new Node(7);
		
		binTree.convertTreeToSumTree(binTree.root);
		
		binTree.inorderTravesal(binTree.root);
		
	}
}
