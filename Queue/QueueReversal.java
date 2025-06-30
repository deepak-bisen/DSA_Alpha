package alpha;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			q.add(i);
		}
		reverseQ(q);

		while (!q.isEmpty()) {
			System.out.print(q.remove() + " ");
		}
	}

	private static void reverseQ(Queue<Integer> q) {
		Stack<Integer> s = new Stack<>();

		while (!q.isEmpty()) {
			s.add(q.remove());
		}
		while (!s.isEmpty()) {
			q.add(s.pop());
		}
	}
}
