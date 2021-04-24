package filesprocessing.parser;

import filesprocessing.TypeTwoError;

/** An exception thrown whenever the file is not in the right format. */
public class BadFormatException extends TypeTwoError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * BadFormat exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadFormatException(String message) {
		super(message);
	}

}
