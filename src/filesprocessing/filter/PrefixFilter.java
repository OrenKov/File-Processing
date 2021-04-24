package filesprocessing.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** A Prefix-Name Filter, which filters files if they starts with a given string. */
public class PrefixFilter extends Filter {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The given name of a file by the user */
	private final String startSequence;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A Prefix Filter constructor.
	 * @param string The string to be searched at the beginning of the file name.
	 */
	public PrefixFilter(String string) {
		this.startSequence = string;
	}


	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that their name (excluding path) starts with a given String.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> (!file.getName().startsWith(startSequence)));

		return (arrayAsList.toArray(new File[0]));
	}
}
