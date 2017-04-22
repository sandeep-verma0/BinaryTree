package com.learnbycoding.binaryTreeExamples;

public class IsTreeFoldable {

	// Root of Binary Tree
	Node root;

	IsTreeFoldable() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node getMirror(Node root){
		
		if(root==null)
			return null ;
		
		Node temp =  getMirror(root.right);
		root.right = getMirror(root.left);
		root.left = temp;
		
		return root;
	}
	
	
	private boolean isSubstructure(Node root1, Node root2){
		
		if(root1==null && root2==null)
			return true;
		
		if(root1!=null && root2!=null && isSubstructure(root1.left, root2.left) && isSubstructure(root1.right, root2.right))
			return true;
		
		return false;
	}
	
	private boolean isTreeFoldable(Node root){
		
		if(root==null)
			return true;
		
		root.left=getMirror(root.left);
		
		boolean isTreeFoldable = isSubstructure(root.left, root.right);
		
		root.left=getMirror(root.left);
		
		return isTreeFoldable;
	}

	public static void main(String[] args) {

		IsTreeFoldable binTree = new IsTreeFoldable();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.right.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.left.right.left = binTree.new Node(6);
		binTree.root.right.left.right = binTree.new Node(7);
		
		System.out.println("Is tree Foldable --> " +binTree.isTreeFoldable(binTree.root));
	}

}
