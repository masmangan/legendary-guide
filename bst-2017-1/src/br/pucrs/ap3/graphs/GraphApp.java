package br.pucrs.ap3.graphs;

public class GraphApp {
	public static void main(String[] args) {
//		AbstractGraph g = new Graph(5);
//
//		g.addEdge(1, 2);
//		g.addEdge(1, 5);
//
//		g.addEdge(2, 3);
//		g.addEdge(2, 4);
//		g.addEdge(2, 5);
//
//		g.addEdge(3, 4);
//
//		g.addEdge(4, 5);
		
//		AbstractGraph g = new Graph(5);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(2, 4);
//		g.addEdge(2, 5);		
//
//		System.out.println(g);
//		// System.out.println(g.getNext(2));
////		System.out.println(g.breadth(1));
//		System.out.println(g.depth(1));

		
//		AbstractGraph g = new Graph(3);
//		g.addEdge(1, 2, 5);
//		g.addEdge(1, 3, 10);
//		g.addEdge(2, 3, 20);
//		
//		System.out.println(g.kruskal());
//		
		
//		AbstractGraph g = new DirectedGraph(5);
//		g.addEdge(1, 2, 3);
//		g.addEdge(1, 3, 10);
//		g.addEdge(1, 5, 4);
//		
//		g.addEdge(2, 4, 1);
//		g.addEdge(2, 5, 7);
//		
//		g.addEdge(3, 2, 4);
//		
//		g.addEdge(4, 3, 5);
//		g.addEdge(4, 1, 2);
//		
//		g.addEdge(5, 4, 6);
//		System.out.println(g);
//	
//		int[][] r = g.floydWarshall();
//		for (int i = 1; i < r.length; i++) {
//			for (int j = 1; j < r.length; j++) {
//				System.out.printf("%4d", r[i][j]);
//			}
//			System.out.println();
//			
//		}
		
		DirectedGraph g = new DirectedGraph(3);
		g.addEdge(1, 2, 15);
		g.addEdge(2, 3, 25);

		//System.out.println(g.pathFromTo(1, 3));
		System.out.println(g.fordFulkerson(1, 3));
		
		
		
	}
}
