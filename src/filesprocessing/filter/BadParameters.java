package filesprocessing.filter;

import filesprocessing.TypeOneError;

/**
 * A General BadParameters exception. Inherit to more specific cases of bad parameters, will be used when a
 * general bad-parameters occasion happens.
 */
public class BadParameters extends TypeOneError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * BadParameters exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadParameters(String message) {
		super(message);
	}

}
