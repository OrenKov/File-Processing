package filesprocessing.filter;

import filesprocessing.FileProcessingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** A hidden-Filter class. filters all the hidden files (in or out, according to given parameter) */
public class HiddenFilter extends Filter {

	/*
	 **************************
	 *		CONSTANTS
	 **************************
	 */

	private static final String HIDDEN_BAD_PARAM_MSG = "problem with the hidden-filter parameters.";

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
	 * An Hidden Filter constructor.
	 * @param expression YES or NO.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 */
	public HiddenFilter(String expression) throws FileProcessingException {
		if (expression.equals(YES) || expression.equals(NO)) {
			this.boolExpression = expression;
		} else {
			throw new BadYesNoParameters(HIDDEN_BAD_PARAM_MSG);
		}
	}

	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that are Hidden / Not Hidden , according to the given input (YES/NO).
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		if (boolExpression.equals(YES)) {
			arrayAsList.removeIf(file -> (!file.isHidden()));
		} else {
			arrayAsList.removeIf(file -> (file.isHidden()));
		}

		return (arrayAsList.toArray(new File[0]));
	}
}
