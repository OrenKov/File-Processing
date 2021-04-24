package filesprocessing.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** A Suffix-Name Filter, which filters files if they end with a given string. */
public class SuffixFilter extends Filter {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The given name of a file by the user */
	private final String endSequence;


	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A Suffix Filter constructor.
	 * @param string The string to be searched at the end of the file name.
	 */
	public SuffixFilter(String string) {
		this.endSequence = string;
	}


	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that their name (excluding path) end with a given String.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> (!file.getName().endsWith(endSequence)));

		return (arrayAsList.toArray(new File[0]));
	}
}
