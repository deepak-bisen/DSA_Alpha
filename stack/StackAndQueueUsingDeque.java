package DSA_Alpha.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackAndQueueUsingDeque {
	static Deque<Integer> deque = new LinkedList<Integer>();

	static class StackS {

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

	static class QueueQ {
		public void add(int data) {
			deque.addLast(data);
		}

		public int remove() {
			int removed = deque.removeFirst();
			return removed;
		}

		public int peek() {
			int data = deque.getFirst();
			return data;

		}
	}

	public static void main(String[] args) {
		StackS s = new StackS();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("Stack Using Deque..... ");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		s.pop();

		System.out.println("\nQueue Using Deque.....");
		QueueQ queue = new QueueQ();
		queue.add(5);
		queue.add(6);
		queue.add(7);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		queue.remove();
	}
}
