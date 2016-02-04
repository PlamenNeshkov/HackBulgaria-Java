package task26;

import java.util.ArrayList;
import java.util.List;

public class StackImp1<T> implements Stack<T> {
	protected List<T> elements;
	
	public StackImp1() {
		elements = new ArrayList<>();
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
		StackImp1<T> other = (StackImp1<T>) uncastOther;
		return this.elements.equals(other.elements);
	}

	@Override
	public int size() {
		return elements.size();
	}
}
