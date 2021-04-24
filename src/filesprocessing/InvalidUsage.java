package filesprocessing;

/** An exception called whenever the user do not use the program correctly */
public class InvalidUsage extends TypeTwoError {

	/* serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * InvalidUsage exception constructor
	 * @param message a message to display whenever getMessage() is called.
	 */
	public InvalidUsage(String message) {
		super(message);
	}
}
