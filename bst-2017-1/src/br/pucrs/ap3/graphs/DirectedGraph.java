package br.pucrs.ap3.graphs;

public class DirectedGraph extends AbstractGraph {

	public DirectedGraph(int size) {
		super(size);
	}

	public void addEdge(int i, int j, int value) {
		checkNode(i);
		checkNode(j);
		m[i][j] = value;
	}

}
