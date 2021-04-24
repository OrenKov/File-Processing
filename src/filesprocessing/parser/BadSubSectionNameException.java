package filesprocessing.parser;

import filesprocessing.TypeTwoError;

/** An exception thrown whenever the a SubSection has a wrong name. */
public class BadSubSectionNameException extends TypeTwoError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * BadSubSectionName exception constructor.
	 * @param message a message to display whenever getMessage() is called.
	 */
	public BadSubSectionNameException(String message) {
		super(message);
	}
}
