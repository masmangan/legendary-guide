package br.pucrs.ap3.heaps;

public class Heap {

	public static boolean isMaxHeap(int[] v) {
		if (v == null)
			throw new IllegalArgumentException("Value v must be not null.");
		for (int i = 0; i <= v.length / 2 - 1; i++) {
			int left = 2 * i + 1;
			if (left < v.length && v[i] < v[left])
				return false;
			int right = 2 * i + 2;
			if (right < v.length && v[i] < v[right])
				return false;
		}
		return true;
	}

}
