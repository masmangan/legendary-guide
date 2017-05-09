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
public class AVLTreeApp {
	public static void main(String[] args) {
		AVLTree bst = new AVLTree();
		System.out.println("Teste da AVL");
		System.out.println(bst);
		System.out.println(bst.size());
		//bst.reportLevel();
		bst.reportHeight();
		bst.add(10);
		System.out.println(bst);
		System.out.println(bst.size());
		//bst.reportLevel();
		bst.reportHeight();
		bst.add(20);
		System.out.println(bst);
		System.out.println(bst.size());
		//bst.reportLevel();
		bst.reportHeight();
		bst.add(30);
		System.out.println(bst);
		System.out.println(bst.size());
		//bst.reportLevel();
		bst.reportHeight();
	}
}
