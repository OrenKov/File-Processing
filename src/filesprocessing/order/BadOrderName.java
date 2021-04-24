package filesprocessing.order;

import filesprocessing.TypeOneError;

/** BadOrderName exception. thrown whenever an invalid order name is given. */
public class BadOrderName extends TypeOneError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * BadOrderName exception constructor
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadOrderName(String message) {
		super(message);
	}

}

