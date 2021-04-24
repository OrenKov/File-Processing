package filesprocessing.section;

import filesprocessing.filter.Filter;
import filesprocessing.order.Order;

/** Section Factory, generates sections. */
public class SectionFactory {

	/**
	 * creates a Section instance out of Filter and Order objects.
	 * @param filter A filter object which is part of a section.
	 * @param order An order object which is part of a section
	 * @return a new section object, containing the given filter and order.
	 */
	public static Section createSection(Filter filter, Order order) {
		return new Section(filter, order);
	}
}
