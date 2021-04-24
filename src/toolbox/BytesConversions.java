package toolbox;

/**
 * A class that is able to convert units for Bytes.
 */
public class BytesConversions {

	/*
	 **************************
	 *		CONSTANTS
	 **************************
	 */

	private static final int KB_TO_BYTES_FACTOR = 1024;


	/*
	 ************************
	 *		METHODS
	 ************************
	 */

	/**
	 * converts between units in KB to units in Bytes.
	 * @param value the value in KB.
	 * @return the value in Bytes.
	 */
	public static double convertKbToBytes(double value) {
		return value * KB_TO_BYTES_FACTOR;
	}


}
