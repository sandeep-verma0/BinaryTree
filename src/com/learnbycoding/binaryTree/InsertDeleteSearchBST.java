package com.learnbycoding.binaryTree;

public class InsertDeleteSearchBST {
	// Root of Binary Tree
	Node root;

	InsertDeleteSearchBST() {
		root = null;
	}

	public class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public void insert(int data) {
		root= insertUtil(root, data);
	}
	
	public Node getRoot(){
		return root;
	}

	private Node insertUtil(Node root, int data) {
		Node newNode = new Node(data);
		if (root == null)
			root = newNode;

		else {
			if (data < root.data)
				root.left=insertUtil(root.left, data);
			else if (data > root.data)
				root.right=insertUtil(root.right, data);
			else if (data == root.data)
				return root;
		}
		
		return root;
	}

	public Node find(int data) {
	
		return findUtil(root, data);
		
	}

	private Node findUtil(Node root, int data) {
		if (root == null || root.data==data)
			return root;

		if (data < root.data)
			return findUtil(root.left, data);
		else if (data > root.data)
		  return findUtil(root.right, data);
	
		return null;
	}

	private Node delete(int data) {

		return deleteUtil(root, data);
	}

	private Node deleteUtil(Node root, int data) {

		if(root==null)
			return null;
		
			if(data < root.data)
				root.left= deleteUtil(root.left,data);
			else if(data > root.data)
				root.right=deleteUtil(root.right,data);
			else {
				
				 // node with only one child or no child
				 if (root.left == null)
		                return root.right;
		            else if (root.right == null)
		                return root.left;
				 
				 root.data = getInorderSuccessor(root.right);
				// Delete the inorder successor
				 root.right=deleteUtil(root.right, root.data);
			}
			
			return root;
		}
	
	private int getInorderSuccessor(Node root){
		int min = root.data;
		while(root.left!=null){
			min = root.left.data;
			root= root.left;
		}
		return min;
	}
	
	private void printInorder(Node root) {
		if(root==null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
	public static void main(String[] args) {
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		
		bst.printInorder(bst.root);
		boolean nodePResent = bst.find(60)==null ? false :true ;
		System.out.println();
		System.out.println("Is root with data 60 present ---> " + nodePResent);
		
		bst.delete(50);
		System.out.println();
		System.out.println("BT after deleting root node 50.");
		bst.printInorder(bst.root);
	}
	
}

