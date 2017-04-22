package com.learnbycoding.binaryTreeExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MaximumSumLeftToRootInBinTree {
	// Root of Binary Tree
	Node root;
	Node targetNode = null;
	MaxSum maxsum=new MaxSum();

	MaximumSumLeftToRootInBinTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;
		int horizotalDistace;

		public Node(int data) {
			this.data = data;
		}
	}

	
	private void maximumSumLeftToRootInBinTree(Node root){
		
		if(root==null)
			return;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> path = new ArrayList<Integer>();
		getMaximumSumPath(root,path,res);
		
		int max=0;
		ArrayList<Integer> maxList=new ArrayList<Integer>();
		
		Iterator<ArrayList<Integer>> itr = res.iterator();
		while(itr.hasNext()){
			int tempMax=0;
			ArrayList<Integer>  tempList= itr.next();
			
			Iterator<Integer> itrList = tempList.iterator();
			while(itrList.hasNext()){
				tempMax= tempMax+itrList.next();
			}
			
			if(tempMax>max)
				{
				max=tempMax;
				maxList=tempList;
				}
		}
		
		System.out.println("Max sum is -> " + max );
		Collections.sort(maxList, new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				// TODO Auto-generated method stub
				return Integer.compare(x, y);
			}
		});
		
	 System.out.println("Leaf to root nodes for maximum array are following.");	
	 maxList.forEach(x-> System.out.print(x+ " "));
	}
	
	private void getMaximumSumPath(Node root ,ArrayList<Integer> path ,ArrayList<ArrayList<Integer>> res){
		
		if(root==null)
			return ;
		
		path.add(root.data);
		//Leaf Node
		if(root.left==null && root.right==null){
			res.add(path);
		}
		
		getMaximumSumPath(root.left,new ArrayList<Integer>(path), res);
		getMaximumSumPath(root.right,new ArrayList<Integer>(path), res);	
		
	}
	
	class MaxSum{
		int max_sum;
	}
	
	private void getMaxSum(Node root){
		
		if(root==null)
			return ;
		
		getTargetNode(root , maxsum,0);
		
		printMaxSumPath(root);
	}
	
	
	private void getTargetNode(Node root , MaxSum max_sum ,int currentSum){
	
		if(root==null)
			return ;
		
		 currentSum = currentSum + root.data;
		 //This is a leaf Node ,update maxSum and  target node
		if(root.left==null && root.right==null){
			if(currentSum > max_sum.max_sum)
			{
				max_sum.max_sum=currentSum;
				targetNode=root;
			}
		}
		
		getTargetNode(root.left, max_sum, currentSum);
		getTargetNode(root.right, max_sum, currentSum);
		
	}
	
	private boolean printMaxSumPath(Node root){
		
		if(root==null)
			return false;
		
		if(targetNode==root || printMaxSumPath(root.left) ||  printMaxSumPath(root.right)){
			System.out.print(root.data+" ");
			return true;
		}
	
			return false;
	}
	
	public static void main(String[] args) {
		MaximumSumLeftToRootInBinTree binTree = new MaximumSumLeftToRootInBinTree();
		binTree.root = binTree.new Node(10);
		binTree.root.left = binTree.new Node(-2);
		binTree.root.right = binTree.new Node(7);

		binTree.root.left.left = binTree.new Node(8);
		binTree.root.left.right = binTree.new Node(-4);
//		binTree.root.right.left = binTree.new Node(6);
//		binTree.root.right.right = binTree.new Node(7);
		
		
		binTree.maximumSumLeftToRootInBinTree(binTree.root);
		
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Another method to print sum from leaf to target node.");
		binTree.getMaxSum(binTree.root);
		System.out.println();
		System.out.println("Maximum sum is --> " + binTree.maxsum.max_sum);
		
		
		
	}
}
