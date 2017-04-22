package com.learnbycoding.binaryTreeExamples;

public class BoundaryTravesalBT {

	// Root of Binary Tree
	Node root;

	BoundaryTravesalBT() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	private void doBinaryTraversal(Node root){
		
		if(root==null)
			return ;
		
		Node leftTraverse= root;
		
		//Print left bounday nodes except left boundary leaf
		while(leftTraverse.left!=null){
			System.out.print(leftTraverse.data+ " ");
			leftTraverse=leftTraverse.left;
		}
		
		//System.out.println();
		//Print all leaves from left sides
		printLeafNodes(root);
		
		//System.out.println();
		//Print right boundary starting from leaf Nodes(Except leafNode)
		printRightBounday(root.right);
	}
	
	private void printLeafNodes(Node root){
		if(root==null)
			return ;
		
		printLeafNodes(root.left);
		if(root.left==null && root.right==null)
		System.out.print(root.data+" ");
		printLeafNodes(root.right);
	}
	
	private void printRightBounday(Node root){
		if(root==null)
			return;
		
		if(root.right.right!=null){
			printRightBounday(root.right);
		}
		
		System.out.print(root.data+ " ");
	}
	
	

	public static void main(String[] args) {

		BoundaryTravesalBT binTree = new BoundaryTravesalBT();
	
	
		
		binTree.root = binTree.new Node(20);
		binTree.root.left = binTree.new Node(8);
		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(12);
		binTree.root.left.right.left = binTree.new Node(10);
		binTree.root.left.right.right = binTree.new Node(14);
		binTree.root.right = binTree.new Node(22);
		binTree.root.right.right = binTree.new Node(25);
		binTree.root.right.right.right = binTree.new Node(27);
		
		binTree.doBinaryTraversal(binTree.root);
		

	}
}
