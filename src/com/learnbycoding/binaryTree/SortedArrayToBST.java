package com.learnbycoding.binaryTree;

public class SortedArrayToBST {
    Node root;
	
    SortedArrayToBST(){
    	root=null;
    }
	class Node{
		int data;
		Node left, right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	private Node createBalanceBSTFromSortedArray(Node root ,int[] array, int start , int end){
		
		int mid= start+ (end-start)/2;
		//System.out.println("mid is" + mid);
		
		if(start>end)
		return null;
			
		root= new Node(array[mid]);
			
		
		//System.out.println(root.data);
		root.left = createBalanceBSTFromSortedArray(root.left, array, start, mid-1);
		root.right = createBalanceBSTFromSortedArray(root.right, array, mid+1, end);
	
		return root;
	}
	
	private void inOrderTraversal(Node root){
		if(root==null)
			return ;
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	
	public static void main(String[] args) {

		SortedArrayToBST inorderBst = new SortedArrayToBST();
		int[] array= {20,30,40,50,60,70,80};
		inorderBst.root =inorderBst.createBalanceBSTFromSortedArray(inorderBst.root, array, 0, array.length-1);
		inorderBst.inOrderTraversal(inorderBst.root);

	}

}
