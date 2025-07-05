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
			//base case
			if (root == null)
				return 0;
			//main logic
			int lh = height(root.left);
			int rh = height(root.right);
			return Math.max(lh, rh) + 1;
		}

		public static int diameter(Node root) {
			//base case
			if(root == null)
				return 0;
			
			//main logic
			int leftDiameter = diameter(root.left);
			int leftHeight = height(root.left);
			int rightDiameter = diameter(root.right);
			int rightHeight  = height(root.right);
			
			int selfDiameter = leftHeight+rightHeight+1;
		
			return Math.max(selfDiameter,Math.max(rightDiameter, leftDiameter));
		}
		public static void main(String[] args) {
			// Creating the tree:
			//     1
			//    / \
			//   2   3
			//  / \ / \
			//  4 5 6 7

			Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.left.left = new Node(4);
			root.left.right = new Node(5);
			root.right.left = new Node(6);
			root.right.right = new Node(7);

			System.out.println("Diameter of tree = "+diameter(root));
		}
}
