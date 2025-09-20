package DSA_Alpha.Heap_PriorityQueue;

import java.util.ArrayList;

public class MaxHeap {

	static class Heap {

		ArrayList<Integer> arr = new ArrayList<Integer>();

		public void add(int data) {
			// add at last index
			arr.add(data);

			int x = arr.size() - 1; // x is child's index
			int parent = (x - 1) / 2; // parent index

			while (arr.get(x) > arr.get(parent)) {
				// swap
				int temp = arr.get(x);
				arr.set(x, arr.get(parent));
				arr.set(parent, temp);

				x = parent;
				parent = (x - 1) / 2;
			}

		}

		public int peek() {
			return arr.get(0);
		}

		private void heapify(int i) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int minIdx = i; // root

			if (left < arr.size() && arr.get(minIdx) < arr.get(left)) {
				minIdx = left;
			}

			if (right < arr.size() && arr.get(minIdx) < arr.get(right)) {
				minIdx = right;
			}

			if (minIdx != i) {
				// swap
				int temp = arr.get(i);
				arr.set(0, arr.get(minIdx));
				arr.set(minIdx, temp);

				heapify(minIdx);
			}

		}

		public int remove() {
			int data = arr.get(0);

			// step1- swap first & last
			int temp = arr.get(0);
			arr.set(0, arr.get(arr.size() - 1));
			arr.set(arr.size() - 1, temp);

			// step2- delete last
			arr.remove(arr.size() - 1);

			// step3- heapify
			heapify(0);

			return data;
		}

		private boolean isEmpty() {

			return arr.size() == 0;
		}
	}

	public static void main(String[] args) {
		Heap pq = new Heap();
		pq.add(3);
		pq.add(4);
		pq.add(1);
		pq.add(5);

		System.out.println("Max heap operations & implementing priority queue");

		while (!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.remove();
		}

	}
}
