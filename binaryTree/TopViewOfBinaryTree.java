package DSA_Alpha.binaryTree;

import DSA_Alpha.binaryTree.SubtreeOfAnotherTree.Node;

public class TopViewOfBinaryTree {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static class Info {
		int hd;
		Node node;

		public Info(Node node, int hd) {
		}
	}

	public static void topView(Node root) {

	}

	public static void main(String[] args) {
		/**
		 *     1
		 *    / \
		 *   2   3
		 *  / \ / \
		 * 4  5 6  7
		 */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
	}

}
