package filesprocessing.filter;

import java.io.File;

/** A All-Filter Class, simply filters all files in the array in. */
public class AllFilter extends Filter {


	/**
	 * The method that filters files from given array, according to the filter type. Filters all files in.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		return arrayToFilter;
	}
}
