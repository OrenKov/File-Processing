package filesprocessing.filter;

import java.io.File;

/** An abstract class of a Filter. */
public abstract class Filter {

	/*
	 **********************
	 *		METHODS
	 **********************
	 */

	/**
	 * The method that filters files from given array, according to the filter type.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	public abstract File[] filter(File[] arrayToFilter);

}
