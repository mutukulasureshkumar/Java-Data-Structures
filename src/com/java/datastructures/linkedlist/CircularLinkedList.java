package com.java.datastructures.linkedlist;


/**
 * @author ${Suresh M Kumar}
 *
 * Dec 8, 2017
 */

/******************************************************

Its a small demo example of circular linked list.
Here, the last element in linked list contains the 
reference of first element. Hence you will not find
null reference element.

IF you print the circular linked list, it goes to 
infinity loop.

********************************************************/


/**Main Class*/
public class CircularLinkedList {
	public static void main(String[] args) {
		MyLinkedList<String> ll = new MyLinkedList<String>();
		ll.add("M");
		ll.add("S");
		ll.add("K");
		ll.print();
	}
}

/***Linked list implementation*/
class MyLinkedList<T> {
	Node<T> start;
	Node<T> end;
	int size;

	public MyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public void add(T data) {
		Node<T> node = new Node<T>(data);
		if (start == null) {
			start = node;
			end = start;
			start.setNode(end);
		} else {
			end.setNode(node);
			end = node;
		}
		end.setNode(start); // Last element storing the first element reference.
		size++;
	}
	public void print() {
		Node<T> node = start;
		while (node.getNode() != null) {
			System.out.println(node.getData());
			node = node.getNode();
		}
	}
}



/**Node class*/
class Node<T> {
	Node<T> node;
	T data;

	public Node(T data) {
		node = null;
		this.data = data;
	}

	public Node<T> getNode() {
		return node;
	}

	public void setNode(Node<T> node) {
		this.node = node;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
