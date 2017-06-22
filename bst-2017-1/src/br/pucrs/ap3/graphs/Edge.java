package br.pucrs.ap3.graphs;

public class Edge implements Comparable<Edge>{

	public int u, v, w;

	public Edge(int u, int v, int w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}

	@Override
	public String toString() {
		return String.format("Edge [u=%s, v=%s, w=%s]", u, v, w);
	}

	@Override
	public int compareTo(Edge e) {
		return new Integer(w).compareTo(new Integer(e.w));
	}



}
