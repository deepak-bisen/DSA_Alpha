package DSA_Alpha.BST;

public class BST {
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

	// searching in BST
	public static boolean search(Node root, int key) {

		// root is null
		if (root == null)
			return false;

		// key found at root
		if (root.data == key)
			return true;

		// if root is greater then key
		if (root.data > key)
			return search(root.left, key); // go to left subtree
		else // if key is greater then root
			return search(root.right, key); // go to right subtree
	}

	// Print within a range
	public static void printInRange(Node root, int k1, int k2) {
		//base case
		if (root == null)
			return;

		// main case
		if (root.data >= k1 && root.data <= k2) {
			printInRange(root.left, k1, k2);
			System.out.print(root.data + " ");
			printInRange(root.right, k1, k2);
		} else if (root.data > k2) {
			printInRange(root.left, k1, k2);
		} else if (root.data < k2) {
			printInRange(root.right, k1, k2);
		}
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

		if (search(root, 7))
			System.out.println("found");
		else
			System.out.println("not found");
		
		System.out.println("printing in range in BST");
		printInRange(root, 5, 12);
	}
}
