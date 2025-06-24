package alpha;

import java.util.Deque;
import java.util.LinkedList;

public class StackAndQueueUsingDeque {
	static class StackS {
		Deque<Integer> deque = new LinkedList<Integer>();

		public void push(int data) {
			deque.addLast(data);
		}

		public int pop() {
			int data = deque.removeLast();
			return data;
		}

		public int peek() {
			return deque.getLast();
		}
	}
	
	public static void main(String[] args) {
		StackS s = new StackS();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
	}
}
