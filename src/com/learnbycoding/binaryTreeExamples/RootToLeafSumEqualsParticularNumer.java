package com.learnbycoding.binaryTreeExamples;


public class RootToLeafSumEqualsParticularNumer {

	// Root of Binary Tree
		Node root;

		RootToLeafSumEqualsParticularNumer() {
			root = null;
		}

		class Node {
			int data;
			Node left, right;

			public Node(int data) {
				this.data = data;
			}
		}
		
		
		private boolean isEqualToSum(Node root , int sum){
			
			if(root==null){
				return (sum==0);
			}
			
			else {
				int subsum =sum-root.data;
				boolean ans = false;
				if(subsum==0 && root.left==null && root.right==null)
					return true;
				
				if(root.left!=null)
					ans= ans || isEqualToSum(root.left, subsum);
				
				if(root.right!=null)
					ans= ans || isEqualToSum(root.right, subsum);
				
				return ans;
			}
		}
	
	public static void main(String[] args) {

		RootToLeafSumEqualsParticularNumer binTree = new RootToLeafSumEqualsParticularNumer();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.right = binTree.new Node(6);
		binTree.root.right.left = binTree.new Node(7);
		binTree.root.right.left.left = binTree.new Node(8);
		binTree.root.right.left.right = binTree.new Node(9);
		
		System.out.println("Is sum equal to 10 --> " + binTree.isEqualToSum(binTree.root, 10));
		
		System.out.println("Is sum equal to 8 --> " + binTree.isEqualToSum(binTree.root, 8));
		
		System.out.println("Is sum equal to 20 --> " + binTree.isEqualToSum(binTree.root, 20));
		
		System.out.println("Is sum equal to 21 --> " + binTree.isEqualToSum(binTree.root, 20));
		
		System.out.println("Is sum equal to 22 --> " + binTree.isEqualToSum(binTree.root, 22));
		
	}

}
