package br.pucrs.ap3.heaps;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	@Test
	public void testNotMaxHeap15() {
		int[] v = { 15, 60, 72, 70, 56, 32, 62, 92, 45, 30, 65 };
		boolean expected = false;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMaxHeap85() {
		int[] v = { 85, 70, 80, 50, 40, 75, 30, 20, 10, 35, 15, 62, 58 };
		boolean expected = true;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMaxHeap97() {
		int[] v = { 92, 70, 72, 60, 65, 32, 62, 15, 45, 30, 56 };
		boolean expected = true;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMaxHeapSingleton() {
		int[] v = { 15 };
		boolean expected = true;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testMaxHeap65() {
		int[] v = { 65, 30, 56 };
		boolean expected = true;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testNotMaxHeap65() {
		int[] v = { 30, 65, 56 };
		boolean expected = false;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}	

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidArgument() {
		Heap.isMaxHeap(null);
	}	
	
}
