package task29;

import task26.Stack;
import task28.LinkedList;

public class ListStack<T> implements Stack<T> {
	protected LinkedList<T> elements;
	
	public ListStack() {
		elements = new LinkedList<>();
	}
	
	@Override
	public void push(T element) {
		elements.add(element);
	}

	@Override
	public T pop() {
		return elements.remove(elements.size() - 1);
	}

	@Override
	public T peek() {
		return elements.get(elements.size() - 1);
	}

	@Override
	public void clear() {
		elements.clear();
	}

	@Override
	public boolean isEmpty() {
		return elements.size() == 0;
	}

	@Override
	public boolean equals(Stack<T> uncastOther) {
		ListStack<T> other = (ListStack<T>) uncastOther;
		return this.elements.equals(other.elements);
	}

	@Override
	public int size() {
		return elements.size();
	}
}
