package com.learnbycoding.binaryTreeExamples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeavelOrderTraversalInSpiralOrder {

	// Root of Binary Tree
	Node root;

	LeavelOrderTraversalInSpiralOrder() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private void printSpiralLevelOrder(Node root) {

		Queue<Node> queue = new LinkedList<Node>();

		boolean reverseOrder = true;
		queue.add(root);

	
		while (!queue.isEmpty()) {

			int count = queue.size();
			// If in reverse Order then take element from head side

			
				Stack<Node> s = new Stack<Node>();  //create a stack

			    //while the queue is not empty
			    while(!queue.isEmpty())
			    {  //add the elements of the queue onto a stack
			       s.push(queue.poll());
			    } 

			    //while the stack is not empty
			    while(!s.isEmpty())
			    { //add the elements in the stack back to the queue
			    	queue.add(s.pop());
			    }
			
			while (count > 0) {
				Node curr = null;

				curr = queue.poll();
				System.out.print(curr.data + " ");

				if(reverseOrder){
				if (curr.left != null)
					queue.add(curr.left);

				if (curr.right != null)
					queue.add(curr.right);
				
				}
				else{
					
					if (curr.right != null)
						queue.add(curr.right);
					
					if (curr.left != null)
						queue.add(curr.left);
					
					}
				count--;
				}
				
			if(reverseOrder)
				reverseOrder=false;
			else 
				reverseOrder=true;
			System.out.println();
		}
	}
	
	
	public void printSpiralLevelOrderRecursive(Node root){
		boolean itr=true;
		for(int i=1;i<=height(root);i++){
			printLevelOrderHelper(root, i , itr);
			itr=!itr;
			System.out.println();
		}
	}
	
	int height(Node node) 
    {
        if (node == null) 
            return 0;
        else
        {
              
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight) 
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
	
	public void printLevelOrderHelper(Node root, int level , boolean itr){
		
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.data + " ");
		
		if(itr){
			printLevelOrderHelper(root.left, level-1, itr);
			printLevelOrderHelper(root.right, level-1, itr);
		}else{
			printLevelOrderHelper(root.right, level-1, itr);
			printLevelOrderHelper(root.left, level-1, itr);
			
		}
	}

	public static void main(String[] args) {
		LeavelOrderTraversalInSpiralOrder binTree = new LeavelOrderTraversalInSpiralOrder();
		binTree.root = binTree.new Node(1);
		binTree.root.left = binTree.new Node(2);
		binTree.root.right = binTree.new Node(3);

		binTree.root.left.left = binTree.new Node(4);
		binTree.root.left.right = binTree.new Node(5);
		binTree.root.right.left = binTree.new Node(6);
		binTree.root.right.right = binTree.new Node(7);
		binTree.root.left.left.left = binTree.new Node(8);
		binTree.root.left.left.right = binTree.new Node(9);
		
		binTree.root.left.right.left = binTree.new Node(10);
		binTree.root.left.right.right = binTree.new Node(11);
		

		binTree.printSpiralLevelOrder(binTree.root);
		System.out.println();
		binTree.printSpiralLevelOrderRecursive(binTree.root);

	}
}
