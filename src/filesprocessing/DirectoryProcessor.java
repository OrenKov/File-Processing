package filesprocessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import filesprocessing.parser.CommandsFileParser;
import filesprocessing.parser.ParsedCommandsFile;
import filesprocessing.section.Section;
import sorter.MergeSort;

public class DirectoryProcessor {

	/*
	 **********************
	 *		CONSTANTS
	 **********************
	 */

	/* a message printed to the screen when the user gave wrong amount of arguments to the command line */
	private static final String NUM_OF_ARGS_MESSAGE = "Wrong usage. Should receive 2 arguments.\n";

	/* a message printed to the screen when the first argument is not a directory */
	private static final String FILE_ONE_NO_DIRECTORY_MESSAGE = "Wrong usage. supply a directory path for " +
																"first argument.\n";

	/* a message printed to the screen when the second argument is not a file */
	private static final String FILE_TWO_NO_FILE_MESSAGE = "Wrong usage. supply a file path " +
														   "for the second argument. \n";

	/* a message printed to the screen when a warning is caught.. */
	private static final String WARNING_MESSAGE = "Warning in line ";

	/* a message printed to the screen when type 2 message is caught. */
	private static final String TYPE_TWO_MESSAGE = "ERROR: ";

	/* number of required arguments for the program to run*/
	private static final int NUM_OF_ARGS = 2;

	/* index of the source directory in the args array */
	private static final int SOURCE_DIRECTORY_INDEX = 0;

	/* index of the file in the args array */
	private static final int COMMANDS_FILE_INDEX = 1;


	/*
	 **********************
	 *		METHODS
	 **********************
	 */

	/*
	 * Verifies the arguments are legit: 2 of them, and in the right order. assumes the file and directory
	 * exists.
	 */
	private static void verifyArgs(String[] args) throws TypeTwoError {
		if (args.length != NUM_OF_ARGS) {
			throw new InvalidUsage(NUM_OF_ARGS_MESSAGE);
		}

		File file1 = new File(args[SOURCE_DIRECTORY_INDEX]);
		File file2 = new File(args[COMMANDS_FILE_INDEX]);

		if (!file1.isDirectory()) {
			throw new InvalidUsage(FILE_ONE_NO_DIRECTORY_MESSAGE);
		} else if (!file2.isFile()) {
			throw new InvalidUsage(FILE_TWO_NO_FILE_MESSAGE);
		}
	}

	/*
	 * processing the directory, using the parsed commands file and the filtered files in the directory.
	 * includes: for each section, (1) printing warnings (err) (2) printing filtered and sorted output (out).
	 */
	private static void processDirectory(ArrayList<Section> fileSections, ParsedCommandsFile parsedFile,
										 File[] directoryFiles) {
		Long[] warningLines;
		for (Section section : fileSections) {
			warningLines = parsedFile.getWarningsLines(section);
			File[] filteredFilesArray;

			for (long line : warningLines) {
				System.err.println(WARNING_MESSAGE + line);
			}

			filteredFilesArray = section.getFilter().filter(directoryFiles);
			MergeSort.fileSort(filteredFilesArray, section.getOrder());

			for (File file : filteredFilesArray) {
				System.out.println(file.getName());
			}
		}
	}


	/**
	 * The manager/processor of the directory. verify input, parsing, and processing it to the expected
	 * output.
	 * @param args arguments from the users command line.
	 * @throws FileProcessingException if an error occurred during the file-processing.
	 */
	public static void main(String[] args) throws FileProcessingException {
		try {
			//	CHECK INPUT:
			verifyArgs(args);

			//	INITIATE RESOURCES:
			File directory = new File(args[SOURCE_DIRECTORY_INDEX]);
			File[] directoryFiles = directory.listFiles(file -> (!file.isDirectory()));
			File commandsFile = new File(args[COMMANDS_FILE_INDEX]);
			ParsedCommandsFile parsedFile = new CommandsFileParser(commandsFile.getAbsolutePath()).parse();
			ArrayList<Section> fileSections = parsedFile.getSections();

			// PROCESS:
			processDirectory(fileSections, parsedFile, directoryFiles);

		} catch (TypeTwoError | IOException e) {
			System.err.println(TYPE_TWO_MESSAGE + e.getMessage());
		}
	}
}
