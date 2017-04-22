package com.learnbycoding.binaryTreeExamples;

public class TwoTreesIndentical {
	
	// Root of Binary Tree
	Node root;

	TwoTreesIndentical() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	private boolean identicalTress(Node root1 , Node root2){
		
		if(root1==null && root2==null)
			return true;
		
		else if(root1!=null && root2!=null){
			if(root1.data!=root2.data)
				return false;
			else 
				return (identicalTress(root1.left, root2.left) && identicalTress(root1.right, root2.right));
		}
		
		return false;
	}

public static void main(String[] args) {
	TwoTreesIndentical binTree = new TwoTreesIndentical();
	binTree.root = binTree.new Node(1);
	binTree.root.left = binTree.new Node(2);
	binTree.root.right = binTree.new Node(3);

	binTree.root.left.left = binTree.new Node(4);
	
	
	TwoTreesIndentical binTree1 = new TwoTreesIndentical();
	binTree1.root = binTree.new Node(1);
	binTree1.root.left = binTree.new Node(2);
	binTree1.root.right = binTree.new Node(3);

	binTree1.root.left.left = binTree.new Node(4);
	
	System.out.println("Are tress identical ? : "+ binTree.identicalTress(binTree.root, binTree1.root));
}
}
