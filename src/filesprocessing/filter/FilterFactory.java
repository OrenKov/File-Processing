package filesprocessing.filter;

import filesprocessing.FileProcessingException;

/** Filters Factory, for filters creations. */
public class FilterFactory {

	/*
	 **************************
	 *		CONSTANTS
	 **************************
	 */
	//	FILTER NAMES:
	private static final String ALL = "all";
	private static final String HIDDEN = "hidden";
	private static final String EXECUTABLE = "executable";
	private static final String WRITABLE = "writable";
	private static final String SUFFIX = "suffix";
	private static final String PREFIX = "prefix";
	private static final String CONTAINS = "contains";
	private static final String FILE = "file";
	private static final String SMALLER_THAN = "smaller_than";
	private static final String BETWEEN = "between";
	private static final String GREATER_THAN = "greater_than";

	private static final int NOT_PATTERN_LENGTH = 3;
	private static final int NOT_BETWEEN_PATTERN_LENGTH = 4;

	/*
	 *********************
	 *		POOL
	 *********************
	 */

	/* allFilter - can be static, do not get any external data. */
	private static final AllFilter allFilter = new AllFilter();

	/* notAllFilter - can be static, do not get any external data. */
	private static final NotFilter notAllFilter =  new NotFilter(new AllFilter());


	/*
	 *********************
	 *		METHODS
	 *********************
	 */

	/**
	 * create a filter according to a given string. If filter name is not legit, not returning a filter.
	 * @param filter the filter name.
	 * @return The given filter, if available.
	 * @throws FileProcessingException exception, if encountering issues creating the Filter.
	 */
	public static Filter createFilter(String filter) throws FileProcessingException {
		String[] inputParts = filter.split("#", -1);
		double doubleValue1;
		double doubleValue2;

		// Assuming (according to the program demands) that an additional part to filter-line is always NOT.
		switch (inputParts[0]) {
		case ALL:
			if (inputParts.length > 1) {
				return notAllFilter;
			} else {
				return allFilter;
			}

		case HIDDEN:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new HiddenFilter(inputParts[1]));
			} else {
				return new HiddenFilter(inputParts[1]);
			}

		case EXECUTABLE:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new ExecutableFilter(inputParts[1]));
			} else {
				return new ExecutableFilter(inputParts[1]);
			}

		case WRITABLE:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new WritableFilter(inputParts[1]));
			} else {
				return new WritableFilter(inputParts[1]);
			}

		case SUFFIX:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new SuffixFilter(inputParts[1]));
			} else {
				return new SuffixFilter(inputParts[1]);
			}

		case PREFIX:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new PrefixFilter(inputParts[1]));
			} else {
				return new PrefixFilter(inputParts[1]);
			}

		case CONTAINS:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new ContainsFilter(inputParts[1]));
			} else {
				return new ContainsFilter(inputParts[1]);
			}

		case FILE:
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new FileFilter(inputParts[1]));
			} else {
				return new FileFilter(inputParts[1]);
			}

		case SMALLER_THAN:
			doubleValue1 = Double.parseDouble((inputParts[1]));
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new SmallerThanFilter(doubleValue1));
			} else {
				return new SmallerThanFilter(doubleValue1);
			}

		case GREATER_THAN:
			doubleValue1 = Double.parseDouble((inputParts[1]));
			if (inputParts.length == NOT_PATTERN_LENGTH) {
				return new NotFilter(new GreaterThanFilter(doubleValue1));
			} else {
				return new GreaterThanFilter(doubleValue1);
			}

		case BETWEEN:
			doubleValue1 = Double.parseDouble((inputParts[1]));
			doubleValue2 = Double.parseDouble((inputParts[2]));
			if (inputParts.length == NOT_BETWEEN_PATTERN_LENGTH) {
				return new NotFilter(new BetweenFilter(doubleValue1, doubleValue2));
			} else {
				return new BetweenFilter(doubleValue1, doubleValue2);
			}

		default:
			throw new BadFilterName("problem with given filter name.\n");
		}
	}


	/** Creating the 'all' filter.
	 * @return a new AllFilter. */
	public static Filter createAllFilter() {
		return allFilter;
	}

}
