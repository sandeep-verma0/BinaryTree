package com.learnbycoding.binaryTree;

public class CheckIfEachNodeOfPreOrderTraversalHasOneChild {
	

	private boolean hasOnlyOneChild(int[] pre , int size){
		
		int min,max;
		
		if(pre[size-1]> pre[size-2]){
			min = pre[size-2];
			max= pre[size-1];
		}
		else {
			min = pre[size-1];
			max= pre[size-2];
		}
		
		
		for(int i=size-3; i>=0;i--){
			if(pre[i] < min){
				min=pre[i];
			}else if(pre[i]> max){
				max= pre[i];
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	
public static void main(String[] args) {
	
	 CheckIfEachNodeOfPreOrderTraversalHasOneChild bst = new CheckIfEachNodeOfPreOrderTraversalHasOneChild();
	  int pre[] = new int[]{8, 3, 5, 7, 6};
	  System.out.println("Does preorder travelsal is having on one child --> " + bst.hasOnlyOneChild(pre, pre.length));
}
}
