package br.pucrs.ap3.graphs;

import java.util.ArrayList;
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

	public void fordFulkerson(int source, int target) {
		// TODO: copiar m
		int[][] m2 = new int[m.length][m.length];
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				m2[i][j] = m[i][j];
			}
		}
		// TODO: calcular caminho
		List<Integer> path = pathFromTo(source, target, m2);
		// TODO: decrementar arestas do caminho.

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




