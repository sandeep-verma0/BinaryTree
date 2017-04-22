package com.learnbycoding.binaryTree;

public class LCASortedTreeInorderSuccessorInBST {
	
	private int lca(InsertDeleteSearchBST.Node root, int n1, int n2){
		
		while(root!=null){
		  if(root.data > n1 && root.data < n2 || (root.data < n1 && root.data > n2))
			   break;
		  
		  if(root.data < n1 && root.data < n2)
			  root=root.right;
		  if(root.data > n1 && root.data > n2)
			  root=root.left;
		}
		return root.data;
	}
	
	private void printInAscendingOrder(InsertDeleteSearchBST.Node root ){
		
		if(root==null)
			return;
		
		printInAscendingOrder(root.left);
		System.out.print(root.data+" ");
		printInAscendingOrder(root.right);
	}
	
	private void getInorderSuccessor(InsertDeleteSearchBST.Node root){
		
		if(root==null)
			return;
		
		int inorderSuccessor=0;
		if(root.right!=null)
			inorderSuccessor =root.right.data;
		else return ;
		
		InsertDeleteSearchBST.Node temp=root.right;
		while(temp.left!=null){
			temp=temp.left;
		}
		
		inorderSuccessor=temp.data;
		System.out.println("Inorder successor of " + root.data + " is -> " + inorderSuccessor );
	}

	public static void main(String[] args) {
		LCASortedTreeInorderSuccessorInBST lca = new LCASortedTreeInorderSuccessorInBST();
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		InsertDeleteSearchBST.Node root = bst.getRoot();
		
		System.out.println("Lca of node 40 and 20 is " + lca.lca(root, 20,40));
		
		System.out.println();
		System.out.println("Sorted in ascending order.");
		lca.printInAscendingOrder(root);
		
		System.out.println();
		System.out.println();
		lca.getInorderSuccessor(root.right);
	}

}
