package com.learnbycoding.binaryTreeExamples;

public class MaximumWidthOfTree {
	// Root of Binary Tree
	Node root;

	MaximumWidthOfTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	
	class Count{
		int count;
	}
	private int findMaximumWidth(Node root){
		
		if(root==null)
			return 0;
		
		int max=0;
        for(int i=1;i<=height(root);i++){
        	int temp =levelOrderUtil(root, i);
        	if(max < temp)
        		max= temp;
        }
        
        return max;
	}
	
	private int height(Node root){
		
		if(root==null)
			return 0;
		
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	private int levelOrderUtil(Node root , int level){
		
		if(root==null)
			return 0;
			
		if(level==1)
			return 1;
		
		return (levelOrderUtil(root.left , level-1 )+ levelOrderUtil(root.right , level-1 ));
		
	}

	public static void main(String[] args) {

		MaximumWidthOfTree binTree = new MaximumWidthOfTree();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		binTree.root.right.left.left = binTree.new Node(8);
		binTree.root.right.left.right = binTree.new Node(9);
		binTree.root.right.right.right = binTree.new Node(10);
		binTree.root.right.right.left = binTree.new Node(11);
		binTree.root.left.left.right = binTree.new Node(12);
		binTree.root.left.left.left = binTree.new Node(13);
		
		
		//System.out.println(binTree.levelOrderUtil(binTree.root, 4, binTree.new Count()));
        System.out.println("Maximum width is : " + binTree.findMaximumWidth(binTree.root));
	}
}
