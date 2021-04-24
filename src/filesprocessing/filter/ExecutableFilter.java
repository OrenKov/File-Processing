package filesprocessing.filter;

import filesprocessing.FileProcessingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** An Executable Filter. filters in all the files that are executable. */
public class ExecutableFilter extends Filter {

	/*
	 **************************
	 *		CONSTANTS
	 **************************
	 */

	private static final String YES = "YES";

	private static final String NO = "NO";

	private static final String EXECUTABLE_BAD_PARAM_MSG = "problem with the executable parameters.";

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
	 * An Executable Filter constructor. wrong arguments build it to "YES", by default.
	 * @param expression YES or NO.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 */
	public ExecutableFilter(String expression) throws FileProcessingException {
		if (expression.equals(YES) || expression.equals(NO)) {
			this.boolExpression = expression;
		} else {
			this.boolExpression = YES;
			throw new BadYesNoParameters(EXECUTABLE_BAD_PARAM_MSG);
		}
	}

	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that are Executable / Not Executable, according to the given input (YES/NO).
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		if (boolExpression.equals(YES)) {
			arrayAsList.removeIf(file -> (!file.canExecute()));
		} else {
			arrayAsList.removeIf(File::canExecute);
		}

		return (arrayAsList.toArray(new File[0]));
	}
}
