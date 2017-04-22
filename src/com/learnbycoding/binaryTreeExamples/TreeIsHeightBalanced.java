package com.learnbycoding.binaryTreeExamples;


public class TreeIsHeightBalanced {

	// Root of Binary Tree
	Node root;

	TreeIsHeightBalanced() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	class Height{
		int height;
	}

	private boolean isTreeHeightBalanced(Node root) {

		if(root==null)
			return true;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		if(Math.abs(leftHeight-rightHeight) <=1 && isTreeHeightBalanced(root.left) && isTreeHeightBalanced(root.right))
			return true;
	
		return false;
	
	}


	private boolean isTreeHeightBalancedOptimised(Node root , Height height) {

		if(root==null)
		{
			height.height=0;
			return true;
		}
		
		//Create leftHeight and RightHeight Object 
		Height lHeight = new Height();
		Height rHeight = new Height();
		
		// Pass Height objects and update it's height
		boolean l = isTreeHeightBalancedOptimised(root.left , lHeight);
		boolean r = isTreeHeightBalancedOptimised(root.right , rHeight);
		
		
		int lh= lHeight.height;
		int rh = rHeight.height;
		
		//Update height
		// Important to update height
		height.height = (lh > rh ? lh : rh)+1;
		
		if(Math.abs(lh-rh) >=2)
			return false;
		
		else return l && r;
	
	}
	private int getHeight(Node root){
		
		if(root==null)
			return 0;
		
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}
	
	
	public static void main(String[] args) {

		TreeIsHeightBalanced binTree = new TreeIsHeightBalanced();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		binTree.root.right.left.left = binTree.new Node(8);
		binTree.root.right.left.right = binTree.new Node(9);
		//binTree.root.right.left.right.left = binTree.new Node(10);

		System.out.println("Is height Balanced ? : " + binTree.isTreeHeightBalanced(binTree.root));
		
		
		System.out.println("Is height Balanced ? : " + binTree.isTreeHeightBalancedOptimised(binTree.root , binTree.new Height()));
	}

}
