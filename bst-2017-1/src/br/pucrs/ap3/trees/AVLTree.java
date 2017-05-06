/*
 * Copyright (c) 2017, ALPRO III and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package br.pucrs.ap3.trees;

/**
 * The {@code AVLTree} class is...
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class AVLTree {

	private AVLNode root;
	
	class AVLNode {

		public int key;
		public AVLNode left, right;
		public int height;
	}

	/**
	 * 
	 */
	public AVLTree() {
		root = null;
	}

	/**
	 * 
	 * @param value
	 */
	public void add(int value) {
		root = add0(root, value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(int value) {
		return contains0(root, value);
	}

	/**
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	private AVLNode add0(AVLNode node, int value) {
		if (node == null) {
			AVLNode n = new AVLNode();
			n.key = value;
			n.left = null;
			n.right = null;
			n.height = 0;
			return n;
		}
		if (node.key == value)
			throw new RuntimeException("Valor existente!");
		if (node.key < value) {
			node.right = add0(node.right, value);
			// TODO: AVL
			// Qual o fator de equilibrio? Delta
		} else {
			node.left = add0(node.left, value);
			// TODO: AVL
		}
		// Atualizar altura em cada nodo...
		int hl = getHeight(node.left);
		int hr = getHeight(node.right);
		int h = 1 + Math.max(hl, hr);
		node.height = h;
		return node;
	}

	private int getHeight(AVLNode node) {
		return node == null? -1 : node.height;
	}

	/**
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	private boolean contains0(AVLNode node, int value) {
		if (node == null)
			return false;
		if (node.key == value)
			return true;
		if (node.key < value)
			return contains0(node.right, value);
		return contains0(node.left, value);

	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return size0(root);
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private int size0(AVLNode node) {
		if (node == null)
			return 0;

		return 1 + size0(node.left) + size0(node.right);
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return toString0(root);
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private String toString0(AVLNode node) {
		if (node == null)
			return " # ";
		return toString0(node.left) + String.format(" %d ", node.key) + toString0(node.right);
	}

	/**
	 * Reports level number for every node.
	 * 
	 * Prints key and level for every node. Root node is at level 0.
	 */
	public void reportLevel() {
		reportLevel0(root, 0);
	}

	/**
	 * 
	 * @param node
	 * @param level
	 */
	private void reportLevel0(AVLNode node, int level) {
		if (node != null) {
			System.out.printf("Key=%d Level=%d!\n", node.key, level);

			reportLevel0(node.left, level + 1);
			reportLevel0(node.right, level + 1);
		}

	}
	
	/**
	 * Reports height number for every node.
	 * 
	 * Prints key and height for every node. Leaf nodes are at height 0.
	 */
	public void reportHeight() {
		reportHeight0(root);
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private int reportHeight0(AVLNode node) {
		if (node == null) {
			return -1;
		}
		int hl = reportHeight0(node.left);
		int hr = reportHeight0(node.right);		
		int height = Math.max(hl, hr) + 1;
		System.out.printf("Key=%d Height=%d!\n", node.key, height );
		return height;
	}
	
	
}
