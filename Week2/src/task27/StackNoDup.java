package task27;

import task26.StackImp1;

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

	private static final long serialVersionUID = 1L;

	public DuplicateElementException() {}
	
	public DuplicateElementException(String message) {
		super(message);
	}
};