package com.learnbycoding.binaryTreeExamples;

public class CreateDoubleTree {
	
	// Root of Binary Tree
		Node root;

		CreateDoubleTree() {
			root = null;
		}

		class Node {
			int data;
			Node left, right;

			public Node(int data) {
				this.data = data;
			}
		}
	
		private void createDoubleTree(Node root){
			
			if(root==null)
				return ;
			
			createDoubleTree(root.left);
			createDoubleTree(root.right);
			
			Node leftChild;
			
			leftChild = root.left;
			root.left = new Node(root.data);
			root.left.left = leftChild;
		
		}
		
		
		private void printInorder(Node root) {

			if(root==null)
				return ;
			
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
		
	public static void main(String[] args) {
		
		CreateDoubleTree binTree = new CreateDoubleTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		
		binTree.printInorder(binTree.root);
		System.out.println();
		binTree.createDoubleTree(binTree.root);
		System.out.println("After creating double tree");
		binTree.printInorder(binTree.root);
		
		
	}
	
}
