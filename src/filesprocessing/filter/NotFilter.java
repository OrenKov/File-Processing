package filesprocessing.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** A decorator for Filters. returning the complementary array of the original filter. */
public class NotFilter extends Filter {

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* the original filter being used. */
	private final Filter prevFilter;


	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/** A NOT filter constructor.
	 * @param filter the filter that the decorator will oppose. */
	public NotFilter(Filter filter) {
		this.prevFilter = filter;
	}


	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */

	/**
	 * uses the filter of prevFilter, and filter out all of the results out of the original given file array.
	 * @param arrayToFilter the array of files to filter.
	 * @return a complementary array to the original given filter.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		ArrayList<File> yesArray = new ArrayList<>(Arrays.asList(prevFilter.filter(arrayToFilter)));

		// Remove from arrayAsList:
		arrayAsList.removeAll(yesArray);
		return (arrayAsList.toArray(new File[0]));
	}
}
