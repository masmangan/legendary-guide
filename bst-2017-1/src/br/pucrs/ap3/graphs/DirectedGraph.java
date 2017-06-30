package br.pucrs.ap3.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectedGraph extends AbstractGraph {

	public DirectedGraph(int size) {
		super(size);
	}

	public void addEdge(int i, int j, int value) {
		checkNode(i);
		checkNode(j);
		m[i][j] = value;
	}

	private int counter;
	private int[] color;
	private int[] discovery;
	private int[] finish;

	/**
	 * 
	 * @return
	 */
	public List<Integer> topological() {
		counter = 1;
		color = new int[m.length];
		discovery = new int[m.length];
		finish = new int[m.length];
		for (int u = 1; u < color.length; u++) {
			color[u] = WHITE;
			discovery[u] = -1;
			finish[u] = -1;
		}
		List<Integer> sorted = new ArrayList<>();
		for (int u = 1; u < color.length; u++) {
			if (color[u] == WHITE) {
				topological0(u, sorted);
			}
		}
		return sorted;
	}

	private void topological0(int node, List<Integer> sorted) {
		sorted.add(node);
		color[node] = GRAY;
		discovery[node] = counter;
		counter++;
		for (Integer adjacentNode : getNext(node)) {
			if (!sorted.contains(adjacentNode)) {
				topological0(adjacentNode, sorted);
			}
		}
		color[node] = BLACK;
		finish[node] = counter;
		counter++;
	}
	
	/**
	 * 
	 * @param source
	 * @param target
	 */
	public int fordFulkerson(int source, int target) {
		int fluxo = 0;
		int[][] m2 = new int[m.length][m.length];
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				m2[i][j] = m[i][j];
			}
		}
		List<Integer> path = pathFromTo(source, target, m2);
		while (path.size() != 0) {
			for (int i = 0; i < path.size() - 1; i++) {
				m2[path.get(i)][path.get(i+1)]--;
			}
			path = pathFromTo(source, target, m2);			
		}

		for (int j = 1; j < m2.length; j++) {
			fluxo += m[source][j] - m2[source][j];
		}
		return fluxo;
	}

	public List<Integer> pathFromTo(int source, int target) {
		int[][] m2 = new int[m.length][m.length];
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				m2[i][j] = m[i][j];
			}
		}		
		return pathFromTo(source, target, m2);
	}

	private List<Integer> pathFromTo(int source, int target, int[][] m2) {
		List<Integer> path = new ArrayList<Integer>(); 
		pathFromTo0(source, target, m2, path);
		Collections.reverse(path);
		return path;
	}

	private boolean pathFromTo0(int source, int target, int[][] m2, List<Integer> path) {
		if (source == target) {
			path.add(target);
			return true; 
		}
		for (int j = 1; j < m2.length; j++) {
			if (m2[source][j] != 0) {
				if (pathFromTo0(j, target, m2, path) == true) {
					path.add(source);
					return true;
				}
			}
		}
		return false;
		
	}

	
	
}




