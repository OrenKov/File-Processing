package filesprocessing.order;

import filesprocessing.TypeOneError;

/** An OrderFactory. creating order objects according to demand. */
public class OrderFactory {


	/*
	 ************************
	 *		CONSTANTS
	 ************************
	 */
	private static final String ABS = "abs";
	private static final String TYPE = "type";
	private static final String SIZE = "size";

	private static final int REVERSE_PATTERN_LENGTH = 2;

	private static final String WRONG_ORDER_NAME_MESSAGE = "problem with given order name.";

	/*
	 ************************
	 *		METHODS
	 ************************
	 */

	/**
	 * create a filter according to a given string.
	 * @param order the filter name.
	 * @return The given filter, if available.
	 * @throws TypeOneError TypeOneError exception, if encountering issues creating the Filter.
	 */
	public static Order createOrder(String order) throws TypeOneError {
		String[] inputParts = order.split("#", -1);

		//	Assuming that whenever the length is REVERSE_PATTERN_LENGTH, the given word is REVERSE.
		switch (inputParts[0]) {
		case ABS:
			if (inputParts.length == REVERSE_PATTERN_LENGTH) {
				return new ReverseOrder(AbsOrder.instance());
			}
			return AbsOrder.instance();
		case TYPE:
			if (inputParts.length == REVERSE_PATTERN_LENGTH) {
				return new ReverseOrder(TypeOrder.instance());
			}
			return TypeOrder.instance();
		case SIZE:
			if (inputParts.length == REVERSE_PATTERN_LENGTH) {
				return new ReverseOrder(SizeOrder.instance());
			}
			return SizeOrder.instance();
		default:
			throw new BadOrderName(WRONG_ORDER_NAME_MESSAGE);
		}
	}

	/**
	 * creating an AbsOrder.
	 * @return an AbsOrder object.
	 */
	public static Order createAbsOrder() {
		return AbsOrder.instance();
	}
}
