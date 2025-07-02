package DSA_Alpha.LinkedList;

public class ZigZagLL {
	// node creation (inner class)
	public class Node {
		int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static Node head;
	public static Node tail;
	public static int size;

	// Add at First
	public void addAtFirst(int data) {
		// step-1 create new node
		Node newNode = new Node(data);
		size++;
		if (head == null) {
			head = tail = newNode;
			return;
		}
		// step-2 newNode's next = head
		newNode.next = head;

		// step-3 head = newNode
		head = newNode;
	}

	public void addAtLast(int data) {
		// step-1 create new node
		Node newNode = new Node(data);
		size++;
		if (head == null) {
			head = tail = newNode;
			return;
		}
		// step-2 tail's next = new Node
		tail.next = newNode;

		// step-3 tail = newNode
		tail = newNode;
	}

	// print linked list
	public void printList() {
		if (head == null) {
			System.out.println("list is empty!");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");

	}

	public void zigZag() {
		// find mid
		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = slow;

		// reverse 2nd half
		Node current = mid.next;
		mid.next = null;
		Node prev = null;
		Node next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		Node left = head;
		Node right = prev;
		Node nextL, nextR;
		
		//alternate merge ( zig-zag merge )
		while(left != null && right != null) {
			//zig-zag
			nextL = left.next;
			left.next = right;
			nextR = right.next;
			right.next = nextL;
			//update
			left = nextL;
			right = nextR;
		}
	}

	public static void main(String[] args) {
		ZigZagLL ll = new ZigZagLL();
		ll.addAtFirst(1);
		ll.addAtLast(2);
		ll.addAtLast(3);
		ll.addAtLast(4);
		ll.addAtLast(5);
		ll.addAtLast(6);

		ll.printList();
		ll.zigZag();
		ll.printList();
		
	}
}
