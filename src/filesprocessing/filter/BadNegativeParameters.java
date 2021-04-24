package filesprocessing.filter;

/**
 * A BadNegativeParameters exception. Thrown whenever negative parameters were given to a filter
 * unnecessarily.
 */
public class BadNegativeParameters extends BadParameters {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * BadNegativeParameters exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadNegativeParameters(String message) {
		super(message);
	}
}
