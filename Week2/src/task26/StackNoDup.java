package task26;

public class StackNoDup<T> extends StackImp1<T> {
	
	@Override
	public void push(T element) {
		if (elements.contains(element)) {
			try {
				throw new DuplicateElementException(
						  "You cannot add duplicate elements");
			} catch (DuplicateElementException e) {
				e.printStackTrace();
			}
		}
		elements.add(element);
	}
}

class DuplicateElementException extends Exception {

	public DuplicateElementException() {}
	
	public DuplicateElementException(String message) {
		super(message);
	}
};