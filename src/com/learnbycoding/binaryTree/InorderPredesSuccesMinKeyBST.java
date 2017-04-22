package com.learnbycoding.binaryTree;

public class InorderPredesSuccesMinKeyBST {

	static InsertDeleteSearchBST.Node pre = null;
	static InsertDeleteSearchBST.Node suc = null;

	private int getMinValue(InsertDeleteSearchBST.Node root) {

		if (root == null)
			return 0;

		// Iterate till it's leftmost leaf
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

	private void getInorderPredessorSuccessor(InsertDeleteSearchBST.Node root,
			int key) {

		if (root == null)
			return;

		// System.out.println(root.data);
		if (root.data == key) {
			if (root.left != null)
				pre = inorderPredessorHelper(root.left);

			if (root.right != null)
				suc = inorderSuccessorHelper(root.right);

			return;
		}
		if (key < root.data) {
			suc = root;
			getInorderPredessorSuccessor(root.left, key);
		} else {
			pre = root;
			getInorderPredessorSuccessor(root.right, key);
		}
	}

	private InsertDeleteSearchBST.Node inorderPredessorHelper(
			InsertDeleteSearchBST.Node root) {

		InsertDeleteSearchBST.Node temp = root;
		while (temp.right != null)
			temp = temp.right;
		return temp;
	}

	private InsertDeleteSearchBST.Node inorderSuccessorHelper(
			InsertDeleteSearchBST.Node root) {
		InsertDeleteSearchBST.Node temp = root;
		while (temp.left != null)
			temp = temp.left;
		return temp;
	}

	public static void main(String[] args) {

		InorderPredesSuccesMinKeyBST inorderBst = new InorderPredesSuccesMinKeyBST();
		InsertDeleteSearchBST bst = new InsertDeleteSearchBST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		InsertDeleteSearchBST.Node root = bst.getRoot();

		System.out.println("Min value of bst is --> "
				+ inorderBst.getMinValue(root));

		inorderBst.getInorderPredessorSuccessor(root, 17);
		if (pre != null)
			System.out.println("Inorder predessor of 17 is --> " + pre.data);
		else {
			System.out.println("Inorder predessor of 17 doesn't exist ");
		}
		if (suc != null)
			System.out.println("Inorder successor of 17 is --> " + suc.data);
		else {
			System.out.println("Inorder successor of 17 doesn't exist ");
		}

		System.out.println();
		pre = null;
		suc = null;
		inorderBst.getInorderPredessorSuccessor(root, 90);

		if (pre != null)
			System.out.println("Inorder predessor of 90 is --> " + pre.data);
		else {
			System.out.println("Inorder predessor of 90 doesn't exist ");
		}
		if (suc != null)
			System.out.println("Inorder successor of 90 is --> " + suc.data);
		else {
			System.out.println("Inorder successor of 90 doesn't exist ");
		}

		System.out.println();
		pre = null;
		suc = null;
		inorderBst.getInorderPredessorSuccessor(root, 60);

		if (pre != null)
			System.out.println("Inorder predessor of 60 is --> " + pre.data);
		else {
			System.out.println("Inorder predessor of 60 doesn't exist ");
		}
		if (suc != null)
			System.out.println("Inorder successor of 60 is --> " + suc.data);
		else {
			System.out.println("Inorder successor of 60 doesn't exist ");
		}

	}
}
