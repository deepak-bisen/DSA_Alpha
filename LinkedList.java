package alpha;

public class LinkedList {
	// node creation (inner class)
	public class Node {
		int data;
		Node next;

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

	public void addInMiddle(int index, int data) {
		// step-1 create new node
		Node newNode = new Node(data);
		if (index == 0) {
			addAtFirst(data);
			return;
		}
		Node temp = head;
		int i = 0;
		// step-2 traverse till index-1
		while (i < index - 1) {
			temp = temp.next;
			i++;
		}
		// step-3 add links
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
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

	public int removeFirst() {
		if (size == 0) {
			System.out.println("linked list is empty.");
			return Integer.MIN_VALUE;
		} else if (size == 1) {
			int value = head.data;
			head = tail = null;
			size = 0;
			return value;
		}
		int value = head.data;
		head = head.next;
		size--;
		return value;
	}

	public int removeLast() {
		if (head == null) {
			System.out.println("linked list is empty.");
			return Integer.MIN_VALUE;
		} else if (head.next == null) {
			int value = head.data;
			head = tail = null;
			size = 0;
			return value;
		}
		// prev: i = size-2
		Node prev = head;
		for (int i = 0; i < size - 2; i++) {
			prev = prev.next;
		}
		int value = prev.next.data; // tail's data
		prev.next = null;
		tail = prev;
		size--;
		return value;
	}

	public int itrSearch(int key) {
		Node temp = head;
		int idx = 0;
		while (temp != null) {
			if (temp.data == key) {
				return idx; // key found
			}
			temp = temp.next;
			idx++;
		}
		// key not found
		return -1;
	}

	public int recursiveSearch(int key) {
		return helperRecSearch(head, key);
	}

	public int helperRecSearch(Node head, int key) {
		// base case
		if (head == null)
			return -1;

		if (head.data == key)
			return 0;
		int index = helperRecSearch(head.next, key);
		if (index == -1)
			return -1;

		return index + 1;
	}

	public void reverseITR() {
		Node prev = null;
		Node current = tail = head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void deleteNthFromEnd(int n) {
		// calculati size of list
		int s = 0; // size
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			s++;
		}
		if (n == s) {
			head = head.next; // remove first element
			return;
		}

		// (size - n ) index
		int i = 1;
		int iToFind = s - n;
		Node prev = head;
		while (i < iToFind) {
			prev = prev.next;
			i++;
		}
		prev.next = prev.next.next;
		return;
	}

// slow-fast approach
	public Node findMiddle(Node head) { // helper for palindrome ll
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next; // +1
			fast = fast.next.next; // +2
		}
		return slow; // slow is the middleNode
	}

	public boolean checkPalindrome() {
		// if linkedlist is empty or has one node
		if (head == null || head.next == null)
			return true;

		// step1 - find middle
		Node midNode = findMiddle(head);
		// step2 - reverse 2nd half
		Node prev = null;
		Node current = midNode;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		Node right = prev; // right half head
		Node left = head;
		// step3 - check left half == right half
		while (right != null) {
			if (left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	//Detect a loop/Cycle in a LL
	public static boolean isCycle() {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next  != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;  //cycle exist
		}
		return false;  //cycle not exist
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.printList();
		ll.addAtFirst(11);
		ll.printList();
		ll.addAtFirst(12);
		ll.printList();
		ll.addAtLast(13);
		ll.printList();
		ll.addAtLast(14);
		ll.printList();
		ll.addInMiddle(0, 17);
		ll.printList();
		ll.addInMiddle(3, 21);
		ll.printList();
		
		System.out.println("size of linked list: " + size);
		System.out.println("removed element: " + ll.removeFirst());
		ll.printList();
		
		System.out.println("size of linked list: " + size);
		System.out.println("removed element: " + ll.removeLast());
		ll.printList();
		
		System.out.println("size of linked list: " + size);
		System.out.println("(Iterative search)Key found at: " + ll.itrSearch(21));

		System.out.println("(Recursive search)key found at: " + ll.recursiveSearch(11));
		ll.reverseITR();
		ll.printList();
		
		ll.deleteNthFromEnd(3); // 3rd element from end
		ll.printList();
		
		System.out.println("is ll Palindrome? ="+ll.checkPalindrome()); //check ll is palindrome ?
		
	/*	head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = head;
		*/
		boolean isCycle = isCycle();
		System.out.println("Is LL Cyclic? ="+isCycle);
		
	}

}
