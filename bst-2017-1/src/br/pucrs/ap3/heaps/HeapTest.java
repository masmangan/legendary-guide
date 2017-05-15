package br.pucrs.ap3.heaps;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	@Test
	public void testNotMaxHeap() {
		int[] v = { 15, 60, 72, 70, 56, 32, 62, 92, 45, 30, 65 };
		boolean expected = false;
		boolean actual = Heap.isMaxHeap(v);
		assertEquals(expected, actual);
	}

}
