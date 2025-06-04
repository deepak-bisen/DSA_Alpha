package alpha;

public class IsCycleLL {
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

	//remove a cycle in linkedlist
		public static void removeCycle() {
	     //detect cycle
			Node slow = head;
			Node fast = head;
			boolean cycle = false;
			while(fast != null && fast.next  != null) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast) {
					cycle =  true;  //cycle exist
				  break;			    
				}
			}
			if(cycle == false)
				return ;
			
			//find meeting point
			slow = head;
			Node prev  = null; //last node
			while(slow != fast) {
				prev = fast;
				slow = slow.next;
				fast = fast.next;
			}
			//remove cycle --> last.next= null
			prev.next = null;	
		}
	public static void  main(String[] args){
		IsCycleLL list = new IsCycleLL(); 
	  head = list.new Node(1);
	  Node temp = list.new Node(2);
	  head.next = temp;
	  head.next.next = list.new Node(3);
	  head.next.next.next = head;

	 System.out.println(isCycle());
	 removeCycle();
	 System.out.println(isCycle());
	 }
	}
