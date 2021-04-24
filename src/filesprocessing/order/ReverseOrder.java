package filesprocessing.order;

import java.io.File;

/** A decorator for Order objects, that reverses their outcome. */
public class ReverseOrder extends Order {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* decorated Order. */
	private final Order prevOrder;


	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * ReverseOrder decorator constructor.
	 * @param order the order object to reverse.
	 */
	public ReverseOrder(Order order) {
		this.prevOrder = order;
	}


	/*
	 ************************
	 *		METHODS
	 ************************
	 */

	/**
	 * The compare method of the comparator. opposite the result of original comparator.
	 * @param o1 first file to compare
	 * @param o2 second file to compare
	 * @return Returns a negative integer, zero, or a positive integer as the first argument is less than,
	 * 		equal to, or greater than the second.
	 */
	@Override
	public int compare(File o1, File o2) {
		return (prevOrder.compare(o1, o2) * -1);
	}
}
