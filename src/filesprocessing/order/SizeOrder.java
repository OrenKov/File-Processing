package filesprocessing.order;

import java.io.File;

/** An Order objects, that order Files according to their size. a singleton */
public class SizeOrder extends Order {

	/*
	 **********************************************
	 *		DATA-MEMBERS & PRIVATE CONSTRUCTOR
	 **********************************************
	 */

	/* The singleton. */
	private static final SizeOrder sizeOrderSingleton = new SizeOrder();

	/* Private constructor */
	private SizeOrder() {}


	/*
	 ************************
	 *		METHODS
	 ************************
	 */

	/**
	 * instance method for SizeOrder.
	 * @return an SizeOrder instance.
	 */
	public static SizeOrder instance() {
		return sizeOrderSingleton;
	}

	/**
	 * compare method - between two files, size (a-z) and file path (a-z) as second parameter.
	 * @param o1 first file to compare
	 * @param o2 second file to compare
	 * @return Returns a negative integer, zero, or a positive integer as the first argument is less than,
	 * 		equal to, or greater than the second.
	 */
	@Override
	public int compare(File o1, File o2) {
		long flag = o1.length() - o2.length();
		if (flag == 0) {
			AbsOrder newOrder = AbsOrder.instance();
			return newOrder.compare(o1, o2);
		}
		return (int) flag;
	}
}
