package com.learnbycoding.binaryTree;

public class KthSmallestElementWithMorrisTraversal {

	
	private int kthSmallerstElement(InsertDeleteSearchBST.Node root , int k){
		
		int count=0;
		InsertDeleteSearchBST.Node pre;
		int kthSmall=0;
		
		InsertDeleteSearchBST.Node curr= root;
		
		while(curr!=null){
			
			if(curr.left==null){
				
				count++;
				if(count==k)
					kthSmall= curr.data;
				
				curr=curr.right;
			}else{
				
				pre=curr.left;
				
				//If pre.right is null that means this is inorder predessor of current element
				//If pre.right is equal to current that means we have visited this node earlier
				while(pre.right!=null && pre.right!=curr)
				pre=pre.right;
				
				if(pre.right==null){
					pre.right=curr;
					curr=curr.left;
				}else{
					//Delink the right 
					
					pre.right=null;
					
					//Visited this node
					count++;
					
					if (count==k)
	                    kthSmall = curr.data;
					
					curr= curr.right;
				}
			
			}
		}
		
		return kthSmall;
	}
	
	
	public static void main(String[] args) {

		KthSmallestElementWithMorrisTraversal elementInbst = new KthSmallestElementWithMorrisTraversal();
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		InsertDeleteSearchBST.Node root = bst.getRoot();
		
		System.out.println("1th Smallest element is --> " +elementInbst.kthSmallerstElement(root, 1));
		System.out.println("5th Smallest element is --> " +elementInbst.kthSmallerstElement(root, 5));
		System.out.println("7th Smallest element is --> " +elementInbst.kthSmallerstElement(root, 7));
	}

}
