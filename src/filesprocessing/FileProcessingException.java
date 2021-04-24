package filesprocessing;

/**
 * A class of General fileProcessing Exceptions. All exceptions related to file-processing inherit from it.
 */
public abstract class FileProcessingException extends Exception {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * FileProcessingException constructor
	 * @param message a message to display whenever getMessage() is called.
	 */
	public FileProcessingException(String message) {
		super(message);
	}
}
