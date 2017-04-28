package br.pucrs.ap3.trees;

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
