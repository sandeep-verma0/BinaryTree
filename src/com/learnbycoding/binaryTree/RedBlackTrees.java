package com.learnbycoding.binaryTree;

public class RedBlackTrees {

	Node root;

	enum Color {
		RED, BLACK
	};

	class Node {
		int data;
		Node left, right, parent;
		Color color;

		public Node(int data) {
			this.data = data;
			this.left = this.right = this.parent;
			color = Color.RED;
		}
	}

	private void insert(int data) {

		Node pt = new Node(data);
		
		//System.out.println("data is " + data);
		// Do a normal BST insert
		root = insertUtil(root, pt);
		//inorder(root);
		//System.out.println();
		// fix Red Black Tree violations
	    fixViolation(root, pt);
	}
	
	private void fixViolation(Node root , Node pt){
		
		Node parent_pt = null;
		Node grand_parent_pt =null;
		
		while((pt!=root) && (pt.color.equals(Color.RED)) && (pt.parent.color.equals(Color.RED))){
			
			parent_pt = pt.parent;
			grand_parent_pt = parent_pt.parent;
			
			 /*  Case : A
            Parent of pt is left child of Grand-parent of pt */
			if(parent_pt==grand_parent_pt.left){
				
				Node uncle_pt = grand_parent_pt.right;
				
				 /* Case : 1
	               The uncle of pt is also red
	               Only Recoloring required */
				 if ((uncle_pt != null) && (uncle_pt.color == Color.RED)){
					
					grand_parent_pt.color =Color.RED;
					parent_pt.color =Color.BLACK;
					uncle_pt.color = Color.BLACK;
					pt=grand_parent_pt;
				}else {
					
				    /* Case : 2
	                   pt is right child of its parent
	                   Left-rotation required */
					if(pt==parent_pt.right){
						pt=parent_pt;
						rotateLeft(root, pt);
					}
					
					 /* Case : 3
	                   pt is left child of its parent
	                   Right-rotation required */
					pt.parent.color=Color.BLACK;
					pt.parent.parent.color=Color.RED;
	                rotateRight(root, pt.parent.parent);
				}
			} else
	        {
	            Node uncle_pt = grand_parent_pt.left;
	 
	            /*  Case : 1
	                The uncle of pt is also red
	                Only Recoloring required */
	            if ((uncle_pt != null) && (uncle_pt.color == Color.RED))
	            {
	                grand_parent_pt.color =Color.RED;
	                parent_pt.color = Color.BLACK ;
	                uncle_pt.color = Color.BLACK ;
	                pt = grand_parent_pt;
	            }
	            else
	            {
	                /* Case : 2
	                   pt is left child of its parent
	                   Right-rotation required */
	                if (pt == parent_pt.left)
	                {
	                	pt=parent_pt;
	                    rotateRight(root, pt);
	                }
	 
	                /* Case : 3
	                   pt is right child of its parent
	                   Left-rotation required */
	                pt.parent.color=Color.BLACK;
					pt.parent.parent.color=Color.RED;
	                rotateLeft(root, pt.parent.parent);
	                
	            }
	        }
			
		}
		
		 root.color = Color.BLACK;
	}
	
	private void rotateRight(Node root, Node pt)
	{
	    Node pt_left = pt.left;   //1
	 
	    pt.left = pt_left.right;  //2
	 
	    if (pt_left.right != null)   //3
	    	pt_left.right.parent = pt; //4
	
	    pt_left.parent = pt.parent;  //5
	    
	    if (pt.parent == null)   //6
	        root = pt_left;      //7
	    else if (pt == pt.parent.left)  //8
	        pt.parent.left = pt_left;  //9
	    else
	        pt.parent.right = pt_left; //10
	 
	    pt_left.right = pt;  //11
	    pt.parent = pt_left; //12
	}
	
	private void rotateLeft(Node root, Node pt)
	{
	    Node pt_right = pt.right;  //1
	 
	    pt.right = pt_right.left;  //2 
	 
	    if (pt_right.left != null)   //3
	    	pt_right.left.parent = pt; //4 
	 
	    pt_right.parent = pt.parent; //5
	 
	    if (pt.parent == null) //6
	        root = pt_right;   //7
	 
	    else if (pt == pt.parent.left) //8
	        pt.parent.left = pt_right; //9
	 
	    else
	        pt.parent.right = pt_right; //10
	 
	    pt_right.left = pt;  //11
	    pt.parent = pt_right; //12
	}
	 

	private void swap(Node a , Node b){
		Color temp = a.color;
		a.color=b.color;
		b.color=temp;
	}
	private Node insertUtil(Node root, Node pt) {
		
		/* If the tree is empty, return a new node */
		if (root == null) {
			return pt;
		}
		
		 /* Otherwise, recur down the tree */
		if (root.data > pt.data) {
			root.left = insertUtil(root.left, pt);
			root.left.parent = root;
		//	System.out.println("root.data left " + root.data);
		} else if (root.data < pt.data) {
			root.right = insertUtil(root.right, pt);
			root.right.parent = root;
			//System.out.println("root.data right " + root.data);
		}
		
		return root;
	}
	
	private void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left);
		System.out.print(root.data + " " );
		inorder(root.right);
		
	}

	public static void main(String[] args) {
       RedBlackTrees tree = new RedBlackTrees();
       tree.insert(7);
       tree.insert(6);
       tree.insert(5);
       tree.insert(4);
       tree.insert(3);
       tree.insert(2);
       tree.insert(1);
       
       tree.inorder(tree.root);
	}

}
