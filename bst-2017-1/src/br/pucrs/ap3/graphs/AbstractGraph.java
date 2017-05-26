package br.pucrs.ap3.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Grafo não-dirigido (Directed graph - Digrafo).
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
		List<Integer> r = new ArrayList<>();
		for (int j = 1; j < m.length; j++) {
			if (m[i][j] != 0)
				r.add(j);
		}
		return r;
	}
	
	// TODO marcar se foi visitado, para evitar ciclos
	public List<Integer> breadth(int i) {
		checkNode(i);
		// TODO
		return null;
	}

	public List<Integer> depth(int i) {
		checkNode(i);
		// TODO
		return null;
	}
}
