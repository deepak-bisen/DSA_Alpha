package DSA_Alpha.binaryTree;

public class DiameterOfTree {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static int height(Node root) {
		// base case
		if (root == null)
			return 0;
		// main logic
		int lh = height(root.left);
		int rh = height(root.right);
		return Math.max(lh, rh) + 1;
	}

	// Approach-1
	public static int diameter1(Node root) {
		// base case
		if (root == null)
			return 0;

		// main logic
		int leftDiameter = diameter1(root.left);
		int leftHeight = height(root.left);
		int rightDiameter = diameter1(root.right);
		int rightHeight = height(root.right);

		int selfDiameter = leftHeight + rightHeight + 1;

		return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
	}

	// Approach-2
	static class Info {
		int diameter;
		int height;

		public Info(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

	public static Info diameter2(Node root) {
		if(root == null) {
			return new Info(0,0); 
		}
		Info leftInfo = diameter2(root.left);
		Info rightInfo = diameter2(root.right);

		int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
		int heigth = Math.max(leftInfo.height, rightInfo.height)+1;
		
		return new Info(diameter,heigth);
	}

	public static void main(String[] args) {
		// Creating the tree:
		//    1
		//   / \
		//  2   3
		// / \ / \
		// 4 5 6 7

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("Diameter1 of tree = " + diameter1(root));

		System.out.println("Diameter2 of tree = " + diameter2(root).diameter);
	}
}
