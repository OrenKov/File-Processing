package filesprocessing.section;

import filesprocessing.filter.Filter;
import filesprocessing.order.Order;

/**
 * A section class. represents a section in a Commands File, holds a filter for files, and a display order for
 * them.
 */
public class Section {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The section's filter. */
	private final Filter myFilter;

	/* The section's order. */
	private final Order myOrder;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A section constructor.
	 * @param filter The Filter given for the section.
	 * @param order The Order given for section.
	 */
	public Section(Filter filter, Order order) {
		myFilter = filter;
		myOrder = order;
	}


	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */

	/**
	 * A getter for the section's filter object.
	 * @return The filter of the section.
	 */
	public Filter getFilter() {
		return myFilter;
	}

	/**
	 * A getter for the section's order object.
	 * @return The order of the section
	 */
	public Order getOrder() {
		return myOrder;
	}
}
