package filesprocessing.filter;

import filesprocessing.FileProcessingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static toolbox.BytesConversions.convertKbToBytes;

/** GreaterThanFilter class. filters in all the files that their size is greater than a given number. */
public class GreaterThanFilter extends Filter {

	/*
	 ***************************************
	 *		DATA-MEMBERS & CONSTANTS
	 ***************************************
	 */

	private static final String GREATER_THAN_NEGATIVE_MESSAGE = "greater_than received negative parameters.";

	/* The given value by the user, converted to bytes. */
	private final double valueInBytes;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * The Greater_Than Filter constructor.
	 * @param value the lower bound (exclusive) in KB for the filter.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 * */
	public GreaterThanFilter(double value) throws FileProcessingException {
		if (value < 0) {
			throw new BadNegativeParameters(GREATER_THAN_NEGATIVE_MESSAGE);
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
	 * @param arrayToFilter The array to filter.
	 * @return the filtered array.
	 * */
	@Override
	public File[] filter(File[] arrayToFilter) {
		ArrayList<File> arrayAsList = new ArrayList<>(Arrays.asList(arrayToFilter));
		arrayAsList.removeIf(file -> file.length() <= valueInBytes);

		return (arrayAsList.toArray(new File[0]));
	}
}
