package filesprocessing.order;

import java.io.File;

/** An Order object, that order Files according to their absolute path. A singleton. */
public class AbsOrder extends Order {

	/*
	 **********************************************
	 *		DATA-MEMBERS & PRIVATE CONSTRUCTOR
	 **********************************************
	 */

	/* The singleton. */
	private static final AbsOrder absOrderSingleton = new AbsOrder();

	/* Private constructor */
	private AbsOrder() {}

	/*
	 ************************
	 *		METHODS
	 ************************
	 */

	/**
	 * instance method for AbsOrder.
	 * @return an absOrder instance.
	 */
	public static AbsOrder instance() {
		return absOrderSingleton;
	}

	/**
	 * compare method - between two files from according to the a-z.
	 * @param o1 first file to compare
	 * @param o2 second file to compare
	 * @return Returns a negative integer, zero, or a positive integer as the first argument is less than,
	 * 		equal to, or greater than the second.
	 */
	@Override
	public int compare(File o1, File o2) {
		return (o1.getAbsolutePath().compareTo(o2.getAbsolutePath()));
	}


}
