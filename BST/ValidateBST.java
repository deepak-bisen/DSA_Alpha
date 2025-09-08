package DSA_Alpha.BST;

public class ValidateBST {
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

	public static boolean isValidBST(Node root, Node min, Node max) {
		if (root == null)
			return true;

		if (min != null && root.data <= min.data)
			return false;

		if (max != null && root.data >= max.data)
			return false;

		return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
	}

	public static void main(String[] args) {
		int values[] = { 5, 1, 3, 4, 2, 7 };
		Node root = null;

		// inserting data in BST
		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}

		inorder(root);
		System.out.println();

		if (isValidBST(root, null, null))
			System.out.println("valid");
		else
			System.out.println("not valid");

	}
}
