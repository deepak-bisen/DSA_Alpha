package DSA_Alpha.BST;

import java.util.ArrayList;

public class PathToLeaf {
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

	public static void printRoot2leaf(Node root, ArrayList<Integer> path) {
		if (root == null)
			return;

		path.add(root.data);
		if (root.left == null && root.right == null) {
			printPath(path);
		}
		printRoot2leaf(root.left, path);
		printRoot2leaf(root.right, path);
		path.remove(path.size() - 1);

	}

	public static void printPath(ArrayList<Integer> path) {
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + "->");
		}
		System.out.println("Null");
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

		printRoot2leaf(root, new ArrayList<Integer>());
	}
}
