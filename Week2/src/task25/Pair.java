package task25;

public final class Pair {
	private final Object first;
	private final Object second;
	
	public Pair(Object first, Object second) {
		this.first = first;
		this.second = second;
	}
	
	public Object getFirst() {
		return first;
	}
	
	public Object getSecond() {
		return second;
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
	
	public boolean equals(Pair other) {
		if (this.first.equals(other.first) 
	       && this.second.equals(other.second)) {
			return true;
		}
	
		return false;
	}
}
