package DSA_Alpha.Heap_PriorityQueue;

import java.util.ArrayList;

public class HeapDemo {
	static class Heap {

		ArrayList<Integer> arr = new ArrayList<Integer>();

		public void add(int data) {
			// add at last index
			arr.add(data);

			int x = arr.size() - 1; // x is child's index
			int parent = (x - 1) / 2; // parent index

			while (arr.get(x) < arr.get(parent)) {
				// swap
				int temp = arr.get(x);
				arr.set(x, arr.get(parent));
				arr.set(parent, temp);
			}

		}

		public int peek() {
			return arr.get(0);
		}
	}

	public static void main(String[] args) {

	}
}
