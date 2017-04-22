package com.learnbycoding.binaryTreeExamples;

public class GetLevelOfANodeInNBinTree {

	// Root of Binary Tree
	Node root;

	GetLevelOfANodeInNBinTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private int getLevelOfANode(Node root , int data , int level){
		
		if(root==null)
			return 0;
		
		if(root.data==data)
			return level;
		
		  int leftLevel =getLevelOfANode(root.left,data, level+1);
		  int rightLevel = getLevelOfANode(root.right,data, level+1);
		  		  
		  if(leftLevel!=0)
            return leftLevel;
		  else 
			  return rightLevel;
	}
	
	public static void main(String[] args) {
		GetLevelOfANodeInNBinTree binTree = new GetLevelOfANodeInNBinTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.right.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.left.right.left = binTree.new Node(6);
		binTree.root.right.left.right = binTree.new Node(7);
		
		System.out.println();
		for(int i=1;i<=7;i++)
			System.out.println("Level of node -> " + i + " is -> " + binTree.getLevelOfANode(binTree.root, i, 1));
		
	}
}
