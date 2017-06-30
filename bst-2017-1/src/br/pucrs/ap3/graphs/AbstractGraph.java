package br.pucrs.ap3.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Grafo n�o-dirigido (Directed graph - Digrafo).
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public abstract class AbstractGraph {

	protected int[][] m;

	public AbstractGraph(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Size must be 1 or more.");
		m = new int[size + 1][size + 1];
	}

	@Override
	public String toString() {
		String r = "    ";
		for (int j = 1; j < m.length; j++) {
			r += j + " ";
		}
		r += "\n";
		r += "  +";
		for (int j = 1; j < m.length; j++) {
			r += "--";
		}
		r += "\n";
		for (int i = 1; i < m.length; i++) {
			r += i + " | ";
			for (int j = 1; j < m.length; j++) {
				r += m[i][j] + " ";
			}
			r += "\n";
		}
		return r;
	}

	public void addEdge(int i, int j) {
		addEdge(i, j, 1);
	}

	public abstract void addEdge(int i, int j, int value);

	protected void checkNode(int i) {
		if (i <= 0 || i >= m.length)
			throw new IllegalArgumentException("Invalid node:" + i);
	}

	public List<Integer> getNext(int i) {
		checkNode(i);
		List<Integer> r = new ArrayList<Integer>();
		for (int j = 1; j < m.length; j++) {
			if (m[i][j] != 0)
				r.add(j);
		}
		return r;
	}

	// enum {
	//
	// }
	protected static final int WHITE = 10;
	protected static final int GRAY = 20;
	protected static final int BLACK = 30;

	public List<Integer> breadth(int s) {
		List<Integer> r = new ArrayList<>();

		checkNode(s);
		// 1 - 7
		// TODO trocar para enum!
		int color[] = new int[m.length];
		int d[] = new int[m.length];
		int p[] = new int[m.length];
		for (int u = 1; u < color.length; u++) {
			color[u] = WHITE;
			d[u] = 1000;
			p[u] = -1;
		}
		color[s] = GRAY;
		d[s] = 0;
		p[s] = -1;
		// 8, 9
		List<Integer> Q = new LinkedList<Integer>();
		Q.add(s);
		// 10
		while (!Q.isEmpty()) {
			int u = Q.remove(0);
			for (Integer v : getNext(u)) {
				if (color[v] == WHITE) {
					color[v] = GRAY;
					d[v] = d[u] + 1;
					p[v] = u;
					Q.add(v);
				}
			}
			color[u] = BLACK;
			r.add(u);
		}

		// System.out.println(Arrays.toString(d));
		// System.out.println(Arrays.toString(p));

		return r;
	}

	public List<Integer> depth(int s) {
		checkNode(s);
		List<Integer> r = new ArrayList<>();
		depth0(s, r);
		return r;
	}

	private void depth0(int s, List<Integer> r) {
		r.add(s);
		for (Integer v : getNext(s))
			if (!r.contains(v))
				depth0(v, r);
	}


	public List<Edge> kruskal() {
		List<Edge> A = new ArrayList<Edge>();
		List<Set<Integer>> sets = new ArrayList<Set<Integer>>();
		sets.add(null);

		for (int v = 1; v < m.length; v++) {
			Set<Integer> s = new HashSet<Integer>();
			s.add(v);
			sets.add(s);
		}
		System.out.println(sets);

		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 1; i < m.length; i++) {
			for (int j = i + 1; j < m.length; j++) {
				if (m[i][j] != 0) {
					System.out.printf("{%d, %d} w = %d %n", i, j, m[i][j]);
					edges.add(new Edge(i, j, m[i][j]));
				}
			}
		}
		Collections.sort(edges);
		System.out.println(edges);

		for (Edge edge : edges) {
			if (sets.get(edge.u) != sets.get(edge.v)) {
				A.add(edge);
				sets.get(edge.u).addAll(sets.get(edge.v));
				sets.set(edge.v, sets.get(edge.u));
			}
		}

		return A;
	}

	public int[][] floydWarshall() {
		int n = m.length;
		int D[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				D[i][j] = edgeCost(i, j);
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
				}
			}
		}
		return D;
	}

	private int edgeCost(int i, int j) {
		if (i == j)
			return 0;
		int cost = m[i][j];
		if (cost == 0)
			return 100; // Infinite?
		return cost;
	}

	public void fordFulkerson() {
		// TODO:
	}

}
