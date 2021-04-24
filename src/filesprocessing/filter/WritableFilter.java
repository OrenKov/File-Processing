package filesprocessing.filter;

import filesprocessing.FileProcessingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** A Writable Filter. Filters in all the files that are writable. */
public class WritableFilter extends Filter {

	/*
	 **************************
	 *		CONSTANTS
	 **************************
	 */

	private static final String WRITABLE_BAD_PARAM_MSG = "problem with the writable-filter parameters.\n";

	private static final String YES = "YES";

	private static final String NO = "NO";


	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The given name of a file by the user */
	private final String boolExpression;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A Writable Filter constructor.
	 * @param expression YES or NO.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 */
	public WritableFilter(String expression) throws FileProcessingException {
		if (expression.equals(YES) || expression.equals(NO)) {
			this.boolExpression = expression;
		} else {
			throw new BadYesNoParameters(WRITABLE_BAD_PARAM_MSG);
		}
	}

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that are Writable / Not Writable, according to the given input (YES/NO).
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		if (boolExpression.equals(YES)) {
			arrayAsList.removeIf(file -> (!file.canWrite()));
		} else {
			arrayAsList.removeIf(File::canWrite);
		}

		return (arrayAsList.toArray(new File[0]));
	}
}
