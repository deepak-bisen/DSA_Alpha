package DSA_Alpha.BST;

public class DeleteInBST {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (root.data > value) {
			// left subtree
			root.left = insert(root.left, value);
		} else {
			// right subtree
			root.right = insert(root.right, value);
		}
		return root;
	}

	public static void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static Node delete(Node root, int value) {

		if (root.data < value)
			root.right = delete(root.right, value);
		else if (root.data > value)
			root.left = delete(root.left, value);
		else { // voila

			// case 1 - leaf node
			if (root.left == null && root.right == null)
				return null;

			// case 2 - one child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// case 3 - two/both child
			// find in-order successor
			Node IS = findInOrderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}
		return root;
	}

	public static Node findInOrderSuccessor(Node root) {
		while (root.left != null)
			root = root.left;
		return root;
	}

	public static void main(String[] args) {
		int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
		Node root = null;

		// inserting data in BST
		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}

		inorder(root);
		System.out.println();

		root = delete(root, 5);
		System.out.println();

		inorder(root);
	}
}
