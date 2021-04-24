package filesprocessing.parser;

import filesprocessing.FileProcessingException;
import filesprocessing.filter.Filter;
import filesprocessing.filter.FilterFactory;
import filesprocessing.order.Order;
import filesprocessing.order.OrderFactory;
import filesprocessing.section.Section;
import filesprocessing.section.SectionFactory;
import filesprocessing.TypeOneError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A Parsed Commands-File.
 */
public class ParsedCommandsFile {

	/*
	 ***********************
	 *		DATA-MEMBERS
	 ***********************
	 */

	/* The array that holds the sections in order. */
	private final ArrayList<Section> sectionArray;

	/* The map that link a section to its warning lines . */
	private final Map<Section, ArrayList<Long>> sectionsWithWarnings;


	/*
	 ***********************
	 *		CONSTRUCTOR
	 ***********************
	 */

	/** ParsedCommandsFile constructor. */
	ParsedCommandsFile() {
		sectionArray = new ArrayList<>();
		sectionsWithWarnings = new HashMap<>();
	}


	/*
	 ********************
	 *		METHODS
	 ********************
	 */

	/**
	 * get the sections of the commands file, in the order they appeared.
	 * @return the list of the sections in the file.
	 */
	public ArrayList<Section> getSections() {
		return sectionArray;
	}

	/**
	 * get the lines where warning occurred in a section, "sorted" from small to big.
	 * @param section the section related to the warning lines.
	 * @return array of warning lines of a section. if a section is not existed in file, return null. if not
	 * 		warnings for a section, return an empty array,
	 */
	public Long[] getWarningsLines(Section section) {
		return sectionsWithWarnings.get(section).toArray(new Long[0]);
	}


	/*
	 **************************
	 *		PRIVATE-METHODS
	 **************************
	 */

	/*
	 * Creating a section (Filter, Order, and Section), adding it and storing its information (Exceptions,
	 * lines, etc...) in the ParsedCommandsFile instance.
	 *
	 * @param filter the name of the filter in the section.
	 * @param order the name of the order in the section.
	 * @param line the line in the file, where the first line of the section appeared.
	 */
	void addSection(String filter, String order, long line) throws FileProcessingException {
		//	Initiate Resources:
		Filter myFilter;
		Order myOrder;
		ArrayList<Long> warnings = new ArrayList<Long>();    // Empty list.

		//	Create FILTER:
		try {
			myFilter = FilterFactory.createFilter(filter);
		} catch (TypeOneError e) {
			warnings.add(line + 1);
			myFilter = FilterFactory.createAllFilter();
		}

		//	Create ORDER:
		try {
			myOrder = OrderFactory.createOrder(order);
		} catch (TypeOneError e) {
			warnings.add(line + 3);
			myOrder = OrderFactory.createAbsOrder();
		}

		//	Store Data:
		Section mySection = SectionFactory.createSection(myFilter, myOrder);
		sectionsWithWarnings.put(mySection, warnings);
		sectionArray.add(mySection);
	}
}
