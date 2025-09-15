package DSA_Alpha.Heap_PriorityQueue;

import java.util.PriorityQueue;

public class ProirityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		pq.add(2);
		pq.add(5);
		pq.add(1);
		pq.add(3);
		pq.add(4);

		while (!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.remove();

		}
	}
}
