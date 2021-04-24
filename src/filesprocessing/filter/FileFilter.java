package filesprocessing.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** Filters files by file's name. */
public class FileFilter extends Filter {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The given name of a file by the user */
	private final String fileName;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A File-Name Filter constructor.
	 * @param name the file's name, without a path.
	 */
	public FileFilter(String name) {
		this.fileName = name;
	}

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that their name (excluding path) is equal to a given String..
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> (!file.getName().equals(fileName)));

		return (arrayAsList.toArray(new File[0]));
	}
}
