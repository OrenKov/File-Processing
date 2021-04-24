package filesprocessing.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** A Contain-Name Filter, which filters files if they contain a given string. */
public class ContainsFilter extends Filter {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The given name of a file by the user */
	private final String nameToContain;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A Contains-Name Filter constructor.
	 * @param string the string the filter checks.
	 */
	public ContainsFilter(String string) {
		this.nameToContain = string;
	}

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that their name (excluding path) includes/contains a given String.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> (!file.getName().contains(nameToContain)));

		return (arrayAsList.toArray(new File[0]));
	}
}
