package DSA_Alpha.binaryTree;

import DSA_Alpha.binaryTree.LowestCommonAncestor.Node;

public class MinDistanceOfNodes {
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
	
//	lowest common ancestor
	public static Node lca2(Node root, int n1, int n2) {
		if(root == null || root.data == n1 || root.data == n2)
			return root;
		
		Node leftLca = lca2(root.left, n1, n2);
		Node rightLca = lca2(root.right,n1,n2);
		
		//leftLCA = value  rightLCA = null
		if(rightLca == null)
			return leftLca;
		
		//rightLCA = value leftLCA = null
		if(leftLca == null)
			return rightLca;
		
		return root;
				
	}
	
	public static int lcaDist(Node root, int n) {
//		base case
		if(root == null)
			return -1;
		
		if(root.data == n)
			return 0;
		
		if()
	}
	
	public static int minDist(Node root, int n1, int n2) {
		Node lca = lca2(root,n1,n2);
		int dist1 = lcaDist(lca,n1);
		int dist2 = lcaDist2(lca,n2);
		
		return dist1 + dist2; 
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
		
		int n1  = 4, n2 = 6;
		
    }
}
