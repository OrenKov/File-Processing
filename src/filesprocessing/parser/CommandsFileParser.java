package filesprocessing.parser;

import filesprocessing.FileProcessingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The parser of the Commands File. knows its structure, and parse it line by line into a parsed-file object.
 */
public class CommandsFileParser {


	/*
	 ***********************
	 *		CONSTANTS
	 ***********************
	 */

	private static final String FILTER = "FILTER";
	private static final String ORDER = "ORDER";

	/* represents a 3 liner section order-type. */
	private static final String EMPTY_ORDER = "abs";

	private static final String BAD_FORMAT_MESSAGE = "Bad format of Commands File";

	private static final String BAD_SUBSECTION_NAME = "Bad subsection name";


	/*
	 **************************
	 *		DATA-MEMBERS
	 **************************
	 */

	/* the path of the file to parse. */
	private final String commandsFileName;

	/* Represents a line in the file. being read and parsed in several methods. */
	private String lineToRead;

	/* The parsed file, being updated through the program. */
	private final ParsedCommandsFile parsedFile;

	/* a flag used to notify that a filter was read, means a 3 lines section was read. */
	private boolean filterWasRead;

	/* File lines counter. */
	private long lineNumber;

	/* represents the current section line*/
	private long sectionLine;

	/* Used whenever a section is 3 liner instead of 4 liner, to update the current sections line. */
	private long newSectionLine;

	/*
	 **************************
	 *		CONSTRUCTOR
	 **************************
	 */

	/**
	 * A CommandsFile parser constructor. Assuming Commands File is an existing file.
	 * @param commandsFileName the commandsFile absolute path.
	 */
	public CommandsFileParser(String commandsFileName) {
		this.commandsFileName = commandsFileName;
		parsedFile = new ParsedCommandsFile();
		lineNumber = 1;
		filterWasRead = false;
	}


	/*
	 ********************
	 *		METHODS
	 ********************
	 */

	/**
	 * parsing a Commands File.
	 * @return The parsed file.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 * @throws IOException if an I/O error occurs.
	 */
	public ParsedCommandsFile parse() throws FileProcessingException, IOException {
		BufferedReader myCommandFileToRead = new BufferedReader(new FileReader(commandsFileName));
		readFileLines(myCommandFileToRead);
		myCommandFileToRead.close();

		return parsedFile;
	}


	/*
	 ****************************
	 *		PRIVATE-METHODS
	 ****************************
	 */

	/* Reads the file, line by line - throw exceptions if needed, create sections. */
	private void readFileLines(BufferedReader myCommandFileToRead) throws IOException,
																		  FileProcessingException {
		//	Read first line:
		lineToRead = myCommandFileToRead.readLine();
		if (lineToRead != null) {
			parseFirstLine();
			sectionLine = lineNumber;
			filterWasRead = true;
		}

		while (lineToRead != null) {
			//	Read 1st section line, if needed, and parse it:
			if (!filterWasRead) {
				lineToRead = myCommandFileToRead.readLine();
				if (lineToRead == null) {
					break;
				}
				sectionLine = ++lineNumber;
				filterWasRead = false;
			}
			parseFirstLine();

			//	Read 2nd section line, and parse it:
			lineToRead = myCommandFileToRead.readLine();
			lineNumber++;
			String myFilter = parseSecondLine();

			//	Read 3nd section line, and parse it:
			lineToRead = myCommandFileToRead.readLine();
			lineNumber++;
			parseThirdLine();

			//	Read and handle 4th line of a section / 1st line of a new section:
			lineToRead = myCommandFileToRead.readLine();
			lineNumber++;
			String myOrder = handleForthLine();

			//	Add a new section to the parsedFile object:
			parsedFile.addSection(myFilter, myOrder, sectionLine);
			sectionLine = newSectionLine;
		}
	}

	/* Verifies first line contains FILTER indeed. */
	private void parseFirstLine() throws FileProcessingException {
		if (!lineToRead.equals(FILTER)) {
			throw new BadSubSectionNameException(BAD_SUBSECTION_NAME);
		}
	}

	/* Verifies second line is not null. */
	private String parseSecondLine() throws FileProcessingException {
		if (lineToRead == null) {
			throw new BadFormatException(BAD_FORMAT_MESSAGE);
		}
		return lineToRead;
	}

	/* Verifies third line contains ORDER indeed. */
	private void parseThirdLine() throws FileProcessingException, IOException {
		if (lineToRead == null) {
			throw new BadFormatException(BAD_FORMAT_MESSAGE);
		} else if (!lineToRead.equals(ORDER)) {
			throw new BadSubSectionNameException(BAD_SUBSECTION_NAME);
		}
	}

	/* handling the 4th line, which might be part of the old section, or the start of a new one. */
	private String handleForthLine() throws IOException, FileProcessingException {

		//	EOF scenario:
		if (lineToRead == null) {
			return EMPTY_ORDER;
		}

		//	4th line is part of the current section:
		if (!lineToRead.equals(FILTER)) {
			filterWasRead = false;
			return parseForthLine();
		} else {    // it is FILTER, means new section begun:
			filterWasRead = true;
			newSectionLine = lineNumber;
			return EMPTY_ORDER;
		}
	}

	/* Verifies forth line if it is part of the old section */
	private String parseForthLine() throws FileProcessingException, IOException {
		if (lineToRead == null) {
			throw new BadFormatException(BAD_FORMAT_MESSAGE);
		}
		return lineToRead;
	}

}
