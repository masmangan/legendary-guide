/*
 * Copyright (c) 2017, ALPRO III and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package br.pucrs.ap3.trees;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTreeApp {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Teste da BST");
		System.out.println(bst);
		System.out.println(bst.size());
		bst.add(10);
		System.out.println(bst);
		System.out.println(bst.size());
		bst.add(20);
		System.out.println(bst);
		System.out.println(bst.size());
		bst.add(5);
		System.out.println(bst);
		System.out.println(bst.size());
	}
}
