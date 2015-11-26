package task26;

public interface Stack<T> {
	public void push(T element);
	public T pop();
	public T peek();
	
	public void clear();
	public boolean isEmpty();
	
	public boolean equals(Stack<T> other);
	public int size();
}
