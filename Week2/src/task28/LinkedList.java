package task28;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class LinkedList<T> implements LinkedListInteface<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	@Override
	public String toString() {
		List<T> elements = new ArrayList<>();
		
		Node<T> node = head;
		while (node != null) {
			elements.add(node.getValue());
			node = node.getNext();
		}
		
		String joined = elements.stream()
				                .map(x -> String.valueOf(x))
				                .collect(Collectors.joining(", "));
				
		return "[" + joined + "]";
	}
	
	@Override
	public int size() {
		int size = 0;
		Node<T> node = head;
		while (node != null) {
			node = node.getNext();
			size++;
		}
		return size;
	}
	
	private void addAfter(Node<T> node, Node<T> newNode) {
		newNode.setPrev(node);
		newNode.setNext(node.getNext());
		if (node.getNext() == null) {
			tail = newNode;
		} else {
			node.getNext().setPrev(newNode);
		}
		node.setNext(newNode);
	}
	
	private void addBefore(Node<T> node, Node<T> newNode) {
		newNode.setPrev(node.getPrev());
		newNode.setNext(node);
		if (node.getPrev() == null) {
			head = newNode;
		} else {
			node.getPrev().setNext(newNode);
		}
		node.setPrev(newNode);
	}
	
	@Override
	public void addFirst(T value) {
		Node<T> newNode = new Node<>(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.setPrev(null);
			newNode.setNext(null);
		} else {
			addBefore(head, newNode);
		}
	}
	
	@Override
	public void addLast(T value) {	
		if (tail == null) {
			addFirst(value);
		} else {
			Node<T> newNode = new Node<>(value);
			addAfter(tail, newNode);
		}
	}
	
	@Override
	public void add(T value) {
		addLast(value);
	}
	
	@Override
	public void add(int index, T value) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException();		
		}
		
		Node<T> node = head;
		while (node != null && index > 0) {
			node = node.getNext();
			index--;
		}
		Node<T> newNode = new Node<>(value);
		addBefore(node, newNode);
	}
	
	@Override
	public T getFirst() {
		return head.getValue();
	}
	
	@Override
	public T getLast() {
		return tail.getValue();
	}
	
	@Override
	public T get(int index) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException();		
		}
		
		Node<T> curr = head;
		while (curr != null && index > 0) {
			curr = curr.getNext();
			index--;
		}
		return curr.getValue();
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}
	
	@Override
	public int indexOf(T value) {
		int index = 0;
		Node<T> curr = head;
		
		while (curr != null) {
			if (curr.getValue() == value) {
				return index;
			}
			
			curr = curr.getNext();
			index++;
		}
		
		return -1;
	}
	
	@Override
	public T remove(int index) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException();		
		}
		
		Node<T> curr = head;
		while (curr != null && index > 0) {
			curr = curr.getNext();
			index--;
		}
		
		T value = curr.getValue();
		
		curr.getPrev().setNext(curr.getNext());
		curr.getNext().setPrev(curr.getPrev());
		curr = null;
		
		return value;
	}
}
