package filesprocessing.order;

import java.io.File;

/** An Order objects, that order Files according to their types. A singleton. */
public class TypeOrder extends Order {

	/*
	 **********************************************
	 *		DATA-MEMBERS & PRIVATE CONSTRUCTOR
	 **********************************************
	 */

	/* The singleton. */
	private static final TypeOrder typeOrderSingleton = new TypeOrder();

	/* Private constructor */
	private TypeOrder() {}


	/*
	 ************************
	 *		METHODS
	 ************************
	 */

	/**
	 * instance method for TypeOrder.
	 * @return an TypeOrder instance.
	 */
	public static TypeOrder instance() {
		return typeOrderSingleton;
	}

	/**
	 * compare method - between two files, according to fileType (a-z) and file path (a-z) as second
	 * parameter.
	 * @param o1 first file to compare
	 * @param o2 second file to compare
	 * @return Returns a negative integer, zero, or a positive integer as the first argument is less than,
	 * 		equal to, or greater than the second.
	 */
	@Override
	public int compare(File o1, File o2) {
		String fileType1 = parseType(o1);
		String fileType2 = parseType(o2);
		int flag = fileType1.compareTo(fileType2);
		if (flag == 0) {
			AbsOrder newOrder = AbsOrder.instance();
			return newOrder.compare(o1, o2);
		}
		return flag;
	}

	/* Extracting the file type of a file.*/
	private String parseType(File file) {
		String type = "";
		String fileName = file.getName();

		int indexOfLastDot = fileName.lastIndexOf(".");
		if (indexOfLastDot > 0) {
			type = fileName.substring(indexOfLastDot + 1);
		}
		// Else: no dots at all (empty type) or dot at index 0 (hidden file) = empty string.

		return type;

	}
}
