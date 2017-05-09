/*
 * Copyright (c) 2017, ALPRO III and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package br.pucrs.ap3.trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class AVLTreeTest {

	@Test
	public void testEmptyTreeHasSizeZero() {
		BinarySearchTree bst = new BinarySearchTree();
		int expected = 0;
		int actual = bst.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testSingletonTreeHasSizeOne() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		int expected = 1;
		int actual = bst.size();
		assertEquals(expected, actual);
	}	

	@Test(expected=RuntimeException.class)
	public void testNoDoubles() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		bst.add(10);
	}		
	
}
