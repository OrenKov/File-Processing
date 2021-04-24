package filesprocessing.filter;

import filesprocessing.TypeOneError;

/**
 * An IllegalValuesOrder exception. Thrown in ranged filters, when the start value is greater than the end
 * value.
 */
public class IllegalValuesOrder extends TypeOneError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * IllegalValuesOrder exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public IllegalValuesOrder(String message) {
		super(message);
	}
}
