package com.learnbycoding.binaryTree;

import java.util.Stack;

public class FindKthElementInBST {
	
	
	private void findKthSmallestElementInBST(InsertDeleteSearchBST.Node root , int kthElement){
		
		if(root==null)
			return ;
		
	    Stack<InsertDeleteSearchBST.Node> stack = new Stack<InsertDeleteSearchBST.Node>();
	    stack.push(root);
	    
	    InsertDeleteSearchBST.Node  temp=root.left;
	    while(temp!=null){
	    	stack.push(temp);
	    	temp=temp.left;
	    }
	    
	    int count=1;
	    while(!stack.isEmpty() && count!=kthElement){
	    	InsertDeleteSearchBST.Node curr= stack.pop();
	    	count++;
	    	if(curr.right!=null){
	    		
	    		 InsertDeleteSearchBST.Node  temp1=curr.right;
	    		    while(temp1!=null){
	    		    	stack.push(temp1);
	    		    	temp1=temp1.left;
	    		    }
	    	}
	    }
	    
	    InsertDeleteSearchBST.Node kthNode = stack.pop();
	    System.out.println("Kth Smallest Element is --> " + kthNode.data);
	}

	public static void main(String[] args) {
		FindKthElementInBST elementInbst = new FindKthElementInBST();
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		InsertDeleteSearchBST.Node root = bst.getRoot();
		
		elementInbst.findKthSmallestElementInBST(root, 7);
		
	}

}
