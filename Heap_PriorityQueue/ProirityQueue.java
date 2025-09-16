package DSA_Alpha.Heap_PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProirityQueue {
	static class Student implements Comparable<Student> {
		String name;
		int rank;

		public Student(String name, int rank) {
			this.name = name;
			this.rank = rank;
		}

		@Override
		public int compareTo(Student s) {
			return this.rank - s.rank;
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>();
//		PriorityQueue<Student> pq = new PriorityQueue<Student>(Comparator.reverseOrder());

		pq.add(new Student("A", 1));
		pq.add(new Student("B", 8));
		pq.add(new Student("C", 3));
		pq.add(new Student("D", 5));
		pq.add(new Student("E", 2));

		while (!pq.isEmpty()) {
			System.out.println(pq.peek().name+" --> "+pq.peek().rank);
			pq.remove();

		}
	}
}
