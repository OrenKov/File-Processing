package filesprocessing.filter;

import filesprocessing.FileProcessingException;
import static toolbox.BytesConversions.convertKbToBytes;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/** SmallerThanFilter class. filters in all the files that their size is smaller than a given number. */
public class SmallerThanFilter extends Filter {

	/*
	 ****************************************
	 *		CONSTANTS & DATA MEMBERS
	 ****************************************
	 */
	private static final String SMALLER_THAN_NEGATIVE_MESSAGE = "smaller_than received negative parameters.";

	/* the given value in KB, converted to bytes. */
	private final double valueInBytes;

	/*
	 ***********************
	 *		CONSTRUCTOR
	 ***********************
	 */

	/** Smaller Than Filter constructor.
	 * @param value the upper bound (exclusive) in KB for the filter.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 * */
	public SmallerThanFilter(double value) throws FileProcessingException {
		if (value < 0) {
			throw new BadNegativeParameters(SMALLER_THAN_NEGATIVE_MESSAGE);
		}

		this.valueInBytes = convertKbToBytes(value);
	}

	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */
	/**
	 * The method that filters files from given array, according to the filter type.
	 * Filters in all the files that their size is smaller than the given double number in the constructor.
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 * */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> file.length() >= valueInBytes);

		return (arrayAsList.toArray(new File[0]));
	}
}
