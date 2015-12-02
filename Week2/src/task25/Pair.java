package task25;

public class Pair<T> {
	
	private T first;
	private T second;
	
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public void setSecond(T second) {
		this.second = second;
	}
	
	public String toString() {
		StringBuilder pair = new StringBuilder();
		
		pair.append('(');
		pair.append(first.toString());
		pair.append(", ");
		pair.append(second.toString());
		pair.append(')');
		
		return pair.toString(); 
	}
	
	public boolean equals(Pair<T> other) {
		if (this.first.equals(other.first) 
	       && this.second.equals(other.second)) {
			return true;
		}
	
		return false;
	}
}
