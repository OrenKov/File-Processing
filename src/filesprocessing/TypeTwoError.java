package filesprocessing;

/**
 * TypeTwoError, kind of a FileProcessingException. being thrown whenever a more severe error occurs, and
 * causes the program to stop.
 */
public class TypeTwoError extends FileProcessingException {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * TypeTwoError exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public TypeTwoError(String message) {
		super(message);
	}
}
