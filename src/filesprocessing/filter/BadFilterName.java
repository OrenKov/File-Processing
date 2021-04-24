package filesprocessing.filter;

import filesprocessing.TypeOneError;

/** A BadFilterName Exception. thrown whenever a bad filter and was given. */
public class BadFilterName extends TypeOneError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * BadFilterName exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadFilterName(String message) {
		super(message);
	}
}
