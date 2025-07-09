package DSA_Alpha.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
			this.hd = hd;
			this.node = node;
		}
	}

	public static void topView(Node root) {
//Level Order

		Queue<Info> q = new LinkedList<>();
		HashMap<Integer, Node> map = new HashMap<>();

		int minHD = 0;
		int maxHD = 0;
		q.add(new Info(root, 0));
		q.add(null);

		while (!q.isEmpty()) {
			Info curr = q.remove();
			if (curr == null) {
				if (q.isEmpty())
					break;
				else
					q.add(null);
			} else {

				if (!map.containsKey(curr.hd)) {// first time my hd is occurring
					map.put(curr.hd, curr.node);
				}

				if (curr.node.left != null) {
					q.add(new Info(curr.node.left, curr.hd - 1));
					minHD = Math.min(minHD, curr.hd - 1);
				}

				if (curr.node.right != null) {
					q.add(new Info(curr.node.right, curr.hd + 1));
					maxHD = Math.max(maxHD, curr.hd + 1);
				}
			}
		}

		
		System.out.println("Top View Of The Binary Tree");
		for (int i = minHD; i <= maxHD; i++)
			System.out.print(map.get(i).data + " ");

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

		topView(root);
	}

}
