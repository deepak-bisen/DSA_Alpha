package DSA_Alpha.binaryTree;

public class TraversalBinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree {
		static int idx = -1;

		public static Node buildTree(int nodes[]) {
			idx++;
			if (nodes[idx] == -1)
				return null;

			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);

			return newNode;
		}

		// Pre-order Traversal (Root, Left, Right)
		public static void preorder(Node root) {
			if (root == null)
				return;

			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}

		// Post-order Traversal (Left, Right,Root)
		public static void postorder(Node root) {
			if (root == null)
				return;

			preorder(root.left);
			preorder(root.right);
			System.out.print(root.data + " ");
		}

		// In-order Traversal (Left, Root, Right)
		public static void inorder(Node root) {
			if (root == null)
				return;

			preorder(root.left);
			System.out.print(root.data + " ");
			preorder(root.right);
		}

		// Level Order Traversal using Queue
		public static void levelOrder(Node root) {
			if (root == null)
				return;

			java.util.Queue<Node> queue = new java.util.LinkedList<>();
			queue.add(root);
			queue.add(null);

			while (!queue.isEmpty()) {
				Node currNode = queue.remove();
				if (currNode == null) {
					System.out.println();
					if(queue.isEmpty())
						break;
					else
						queue.add(null);
				} else {
					System.out.print(currNode.data + " ");
					if (currNode.left != null)
						queue.add(currNode.left);
					if (currNode.right != null)
						queue.add(currNode.right);
				}
			}
		}

	}

	public static void main(String[] args) {
		int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		System.out.println("Root Of The Binary Tree: " + root.data);

		System.out.print("Pre-order Traversal : ");
		tree.preorder(root);

		System.out.println();

		System.out.print("Post-order Traversal : ");
		tree.postorder(root);

		System.out.println();

		System.out.print("In-order Traversal : ");
		tree.inorder(root);

		System.out.println();

		System.out.println("Level-order Traversal : ");
		tree.levelOrder(root);
	}
}
