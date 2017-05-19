/*
 * Copyright (c) 2017, ALPRO III and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package br.pucrs.ap3.trees;

import java.util.ArrayList;
import java.util.List;

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
	private void reportLevel0(Node node, int level) {
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
	private int reportHeight0(Node node) {
		if (node == null) {
			return -1;
		}
		int hl = reportHeight0(node.left);
		int hr = reportHeight0(node.right);
		int height = Math.max(hl, hr) + 1;
		System.out.printf("Key=%d Height=%d!\n", node.key, height);
		return height;
	}

	// 6. Escreva um algoritmo que apresente o caminho de um nodo que contém um
	// determinado valor até a sua folha, considerando o caminho de maior
	// altura.
	public void caminhoMaiorFolha(int value) {
		caminhoMaiorFolha0(root, value);
	}

	private void caminhoMaiorFolha0(Node node, int value) {
		if (node == null)
			return;
		
		if (node.key == value) {
			// TODO: apresentar o caminho até a folha
			List<Integer> caminho = montarCaminho(node);
			System.out.println(caminho);
		}
		
		caminhoMaiorFolha0(node.right, value);
		caminhoMaiorFolha0(node.left, value);
	}

	private List<Integer> montarCaminho(Node node) {
		if (node == null) {
			return new ArrayList<>();
		} else {
			List<Integer> ce = montarCaminho(node.left);
			List<Integer> cd = montarCaminho(node.right);
			if (ce.size() > cd.size()) {
				ce.add(node.key);
				return ce;
			} else {
				cd.add(node.key);
				return cd;
			}
		}
	}

}



