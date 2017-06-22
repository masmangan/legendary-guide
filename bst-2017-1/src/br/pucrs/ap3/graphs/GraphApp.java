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

		AbstractGraph g = new Graph(3);
		g.addEdge(1, 2, 5);
		g.addEdge(1, 3, 10);
		g.addEdge(2, 3, 20);
		
		System.out.println(g.kruskal());
		
		
		
		
		
		
		
		
	}
}
