package DSA_Alpha.binaryTree;


public class CountOfNodes {
static class Node{
	int data;
	Node left, right;
	
	public Node(int data) {
	this.data = data;
	this.left = null;
	this.right = null;
	}
}

public static int count(Node root) {
	if(root == null)
		return 0;
	
	int leftCount = count(root.left);
	int rightCount = count(root.right);
	return leftCount+rightCount+1;
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
			
			System.out.println("Total Number Of Nodes In Tree = "+ count(root));
}
}
