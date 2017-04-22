package com.learnbycoding.binaryTreeExamples;

public class CreateMirrorOfATree {

	// Root of Binary Tree
		Node root;

		CreateMirrorOfATree() {
			root = null;
		}

		class Node {
			int data;
			Node left, right;

			public Node(int data) {
				this.data = data;
			}
		}
		
		private void inorderTraversal(Node root){
			if(root==null)
				return;
			inorderTraversal(root.left);
			System.out.println(root.data+" ");
			inorderTraversal(root.right);
		}
		
		
		private Node getMirror(Node root){
			
			if(root==null)
				return null;
			
			Node left = getMirror(root.left);
			Node right = getMirror(root.right);
						
			root.left=right;
			root.right=left;		

			return root;
		}
		public static void main(String[] args) {
			CreateMirrorOfATree binTree = new CreateMirrorOfATree();
			binTree.root = binTree.new Node(1);
			binTree.root.left = binTree.new Node(2);
			binTree.root.right = binTree.new Node(3);

			binTree.root.left.left = binTree.new Node(4);
			binTree.root.left.right = binTree.new Node(5);
			binTree.root.right.right = binTree.new Node(7);
			binTree.root.right.left = binTree.new Node(6);

			System.out.println("Intial tree is following.");
			binTree.inorderTraversal(binTree.root);
			System.out.println();
			
			binTree.root=binTree.getMirror(binTree.root);
			
			System.out.println("Final tree is following.");
			binTree.inorderTraversal(binTree.root);
			
		}
}
