package filesprocessing.filter;

import filesprocessing.FileProcessingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static toolbox.BytesConversions.convertKbToBytes;

/** A BetweenFilter class. filters in all files that are between given size (inclusive). */
public class BetweenFilter extends Filter {

	/*
	 **************************
	 *		CONSTANTS
	 **************************
	 */
	private static final String BETWEEN_NEGATIVE_MSG = "negative value(s) were given to between-filter.";

	private static final String BETWEEN_ILLEGAL_MSG = "values given to between-filter are illegal.";

	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* The given start value by the user, converted to bytes. */
	private final double valueStartInBytes;

	/* The given end value by the user, converted to bytes. */
	private final double valueEndInBytes;


	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * The Between Filter constructor.
	 * @param valueStart The file size begin value, in KB.
	 * @param valueEnd The file size end value, in KB.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 */
	public BetweenFilter(double valueStart, double valueEnd) throws FileProcessingException {
		if (valueStart < 0 || valueEnd < 0) {
			throw new BadNegativeParameters(BETWEEN_NEGATIVE_MSG);
		}

		if (valueStart > valueEnd) {
			throw new IllegalValuesOrder(BETWEEN_ILLEGAL_MSG);
		}
		this.valueStartInBytes = convertKbToBytes(valueStart);
		this.valueEndInBytes = convertKbToBytes(valueEnd);
	}


	/**
	 * The method that filters files from given array, according to the filter type. Filters in all the files
	 * that their size is between the given numbers to the constructor.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> (file.length() > valueEndInBytes) ||
									 (file.length() < valueStartInBytes));

		return (arrayAsList.toArray(new File[0]));
	}
}
