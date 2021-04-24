package filesprocessing;

/**
 * TypeOneError, kind of a FileProcessingException. being thrown whenever a simple error (warning) occurs, the
 * program continues in the execution.
 */
public class TypeOneError extends FileProcessingException {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * TypeOneError exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public TypeOneError(String message) {
		super(message);
	}
}
