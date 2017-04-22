package com.learnbycoding.binaryTreeExamples;


public class SumPropertyInATree {
	// Root of Binary Tree
		Node root;
		boolean isChildrenSumEqualParent=true;
		SumPropertyInATree() {
			root = null;
		}

		class Node {
			int data;
			Node left, right;

			public Node(int data) {
				this.data = data;
			}
		}
		
		private int isChildrenSumEqualParent(Node root){
			
			if(root==null)
				return 0;
			
			if(root.right==null && root.left==null)
				return root.data;
			else if(root.right==null && root.left!=null)
				return root.left.data;
			else if(root.right!=null && root.left==null)
				return root.right.data;
			
			int leftChildremSum = isChildrenSumEqualParent(root.left);
			int rightChildremSum = isChildrenSumEqualParent(root.right);
			
			int totalSum =leftChildremSum+ rightChildremSum;
			if(totalSum !=root.data)
				isChildrenSumEqualParent=false;
			
			return totalSum;
		}
		
		
	public static void main(String[] args) {
		SumPropertyInATree binTree = new SumPropertyInATree();
		binTree.root = binTree.new Node(10);
		binTree.root.left = binTree.new Node(8);
		binTree.root.right = binTree.new Node(2);
		
		binTree.root.left.left = binTree.new Node(3);
		binTree.root.left.right = binTree.new Node(5);
		
		binTree.root.right.left = binTree.new Node(1);
		binTree.root.right.right = binTree.new Node(1);
		
		binTree.isChildrenSumEqualParent(binTree.root);
		System.out.println(binTree.isChildrenSumEqualParent);

	}

}
