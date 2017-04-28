/*
 * Copyright (c) 2017, ALPRO III and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package br.pucrs.ap3.trees;

/**
 * The {@code BinarySearchTree} class is...
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTree {

	private Node root;

	/**
	 * 
	 */
	public BinarySearchTree() {
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
	private Node add0(Node node, int value) {
		if (node == null) {
			Node n = new Node();
			n.key = value;
			n.left = null;
			n.right = null;
			return n;
		}
		if (node.key == value)
			throw new RuntimeException("Valor existente!");
		if (node.key < value)
			node.right = add0(node.right, value);
		else
			node.left = add0(node.left, value);
		return node;
	}

	/**
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	private boolean contains0(Node node, int value) {
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
	private int size0(Node node) {
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
	private String toString0(Node node) {
		if (node == null)
			return " # ";
		return toString0(node.left) + String.format(" %d ", node.key) + toString0(node.right);
	}

}
