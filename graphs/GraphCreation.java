package DSA_Alpha.graphs;

import java.util.ArrayList;

public class GraphCreation {
	static class Edge {
		int src;
		int dest;
		int weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;

		}
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		// 0 -vertex
		graph[0].add(new Edge(0, 1, 5));

		// 1 -vertex
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));

		// 2 -vertex
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 2));

		// 3 -vertex
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));

		// 4 -vertex
		graph[4].add(new Edge(4, 2, 2));

	}
	
	public static void main(String[] args) {
		/**
		 *    (5) 
		 * 0-------1 
		 *        / \ 
		 *    (1)/   \ (3) 
		 *      /     \ 
		 *     2-------3 
		 *     |  (1) 
		 *  (2)| 
		 *     |
		 *     4
		 */

		int vertex = 5;
		ArrayList<Edge>[] graph = new ArrayList[vertex]; // null --> empty arraylist

		createGraph(graph);
		
		
		// 2's neighbors
		System.out.println("2's neighbors");
		for (int i = 0; i < graph[2].size(); i++) {
			Edge e = graph[2].get(i); // src, dest, weight
			System.out.print(e.dest+" ");
		}
		
		
		
	}

}
