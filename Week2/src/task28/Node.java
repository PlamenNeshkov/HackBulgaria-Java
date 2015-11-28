package task28;

public class Node<T> {
	private Node<T> prev;
	private Node<T> next;
	private T value;
	
	public Node(T value) {
		this.value = value;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	protected void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public T getValue() {
		return value;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	protected void setNext(Node<T> next) {
		this.next = next;
	}
}
