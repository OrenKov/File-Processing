package filesprocessing.filter;

/**
 * A BadYesNoParameters exception. Thrown whenever YES or NO expected as arguments to the filter, but were
 * not given.
 */
public class BadYesNoParameters extends BadParameters {

	/* serial version */
	private static final long serialVersionUID = 1L;
	/**
	 * BadYesNoParameters exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadYesNoParameters(String message) {
		super(message);
	}
}
