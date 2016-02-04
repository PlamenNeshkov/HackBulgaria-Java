package task28;

public interface LinkedListInteface<T> {
	public String toString();
	
	public int indexOf(T value);
	public int size();
	
	public void addFirst(T value);
	public void addLast(T value);
	public void add(T value);
	public void add(int index, T value);
	
	public T getFirst();
	public T getLast();
	public T get(int index);
	
	public void clear();
	public T remove(int index);
}
