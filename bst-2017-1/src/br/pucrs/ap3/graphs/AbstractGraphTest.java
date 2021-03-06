package br.pucrs.ap3.graphs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AbstractGraphTest {

	@Test
	public void testBreadthG1() {
		AbstractGraph g = new Graph(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		List<Integer> actual = g.breadth(1);
//		List<Integer> expected = new ArrayList<>();
//		expected.add(1);
//		expected.add(2);
//		expected.add(3);
//		expected.add(4);
//		expected.add(5);
		String expected = "[1, 2, 3, 4, 5]";
		assertEquals(expected , actual.toString());
	}

	@Test
	public void testBreadthG2() {
		AbstractGraph g = new Graph(4);
		g.addEdge(1, 2);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		List<Integer> actual = g.breadth(2);
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(1);
		expected.add(4);
		expected.add(3);
		assertEquals(expected , actual);
	}
	
	@Test
	public void testBreadthG3() {
		AbstractGraph g = new Graph(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		List<Integer> actual = g.breadth(1);
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		assertEquals(expected , actual);
	}
	
	
	@Test
	public void testDepthG1() {
		AbstractGraph g = new Graph(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		List<Integer> actual = g.depth(1);
		String expected = "[1, 2, 4, 5, 3]";
		assertEquals(expected , actual.toString());
	}

	@Test
	public void testDepthG2() {
		AbstractGraph g = new Graph(4);
		g.addEdge(1, 2);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		List<Integer> actual = g.depth(2);
		String expected = "[2, 1, 4, 3]";
		assertEquals(expected , actual.toString());
	}
	
	@Test
	public void testDepthG3() {
		AbstractGraph g = new Graph(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		List<Integer> actual = g.depth(1);
		String expected = "[1, 2, 4, 3]";
		assertEquals(expected , actual.toString());
	}		
}
