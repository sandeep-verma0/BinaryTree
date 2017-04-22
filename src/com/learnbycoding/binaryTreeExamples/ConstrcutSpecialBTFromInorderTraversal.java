package com.learnbycoding.binaryTreeExamples;

public class ConstrcutSpecialBTFromInorderTraversal {
	// Root of Binary Tree
	Node root;

	ConstrcutSpecialBTFromInorderTraversal() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private void constructBTUsingInorderTraversal(int[] inorderTraversalArray) {

		if (inorderTraversalArray.length == 0)
			return;
		else if (inorderTraversalArray.length == 1)
			root = new Node(inorderTraversalArray[0]);

		else {
			root = contructBT(root, inorderTraversalArray, 0,
					inorderTraversalArray.length - 1);
		}

	}

	private Node contructBT(Node root, int[] inorderTraversalArray,
			int startIndex, int endIndex) {

		if (startIndex > endIndex)
			return null;

		int maxIndex = maxIndex(inorderTraversalArray, startIndex, endIndex);
		root = new Node(inorderTraversalArray[maxIndex]);

		/*
		 * If this is the only element in inorder[start..end], then return it
		 */
		if (startIndex == endIndex)
			return root;

		root.left = contructBT(root.left, inorderTraversalArray, startIndex,
				maxIndex - 1);
		root.right = contructBT(root.right, inorderTraversalArray,
				maxIndex + 1, endIndex);

		return root;
	}

	private int maxIndex(int[] arr, int startIndex, int endIndex) {
		int maxIndexValue = startIndex;

		while (startIndex <= endIndex) {
			if (arr[startIndex] > arr[maxIndexValue])
				maxIndexValue = startIndex;
			startIndex++;
		}
		return maxIndexValue;
	}

	private void printInoderTravesal(Node root) {
		if (root == null)
			return;

		printInoderTravesal(root.left);
		System.out.print(root.data + " ");
		printInoderTravesal(root.right);
	}

	public static void main(String[] args) {
		ConstrcutSpecialBTFromInorderTraversal binTree = new ConstrcutSpecialBTFromInorderTraversal();
		int[] inorderTraversalArray = { 1, 5, 10, 40, 30, 15, 28, 20 };
		binTree.constructBTUsingInorderTraversal(inorderTraversalArray);

		System.out.println("Inorder traversal of the constructed tree is ");
		binTree.printInoderTravesal(binTree.root);

	}

}
