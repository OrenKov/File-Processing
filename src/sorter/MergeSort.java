package sorter;

import java.io.File;
import java.util.Comparator;

/** A MergeSort Class. currently, can sort an array of files. */
public class MergeSort {

	/*
	 ***********************
	 *		METHODS
	 ***********************
	 */

	/**
	 * sort an array of files according to a given comparator compare method.
	 * @param array The array to sort.
	 * @param c The comparator being used for the sort.
	 */
	public static void fileSort(File[] array, Comparator<File> c) {
		mergeSort(array, 0, array.length - 1, c);
	}


	/*
	 ****************************
	 *		PRIVATE-METHODS
	 ****************************
	 */

	/* The actual merging method, working recursively and sorting the given array using merge method.*/
	private static void mergeSort(File[] array, int begin, int end, Comparator<File> c) {
		// Sort the part of the given array, if there is still something to sort:
		if (begin < end) {
			int middle = ((begin + end) / 2);
			mergeSort(array, begin, middle, c);
			mergeSort(array, middle + 1, end, c);
			merge(array, begin, middle, end, c);
		}
	}

	/* gets 2 sorted arrays-parts and merges them into a new array that includes them all.
	 * modifies the original array, while keeping the same positions/bounds of the original array. */
	private static void merge(File[] array, int begin, int middle, int end, Comparator<File> c) {

		// Initiate Resources (sizes, bounds, and new "dummy" arrays):
		int sizeLeft = middle - begin + 1;
		int sizeRight = end - middle;
		File[] left = new File[sizeLeft];
		File[] right = new File[sizeRight];
		int leftRunningIndex = 0;
		int rightRunningIndex = 0;
		int beginOfMergedArrayIndex = begin;

		if (sizeLeft >= 0) {
			System.arraycopy(array, begin, left, 0, sizeLeft);
		}
		if (sizeRight >= 0) {
			System.arraycopy(array, middle + 1, right, 0, sizeRight);
		}

		//	Fill the original array with the elements in the right order:
		while ((leftRunningIndex < sizeLeft) && (rightRunningIndex < sizeRight)) {
			if (c.compare(left[leftRunningIndex], right[rightRunningIndex]) > 0) {
				array[beginOfMergedArrayIndex] = right[rightRunningIndex];
				rightRunningIndex++;
			} else {
				array[beginOfMergedArrayIndex] = left[leftRunningIndex];
				leftRunningIndex++;
			}
			beginOfMergedArrayIndex++;
		}

		// Fill in left overs:
		if (rightRunningIndex < sizeRight) {
			while (rightRunningIndex < sizeRight) {
				array[beginOfMergedArrayIndex] = right[rightRunningIndex];
				rightRunningIndex++;
				beginOfMergedArrayIndex++;
			}
		} else {
			while (leftRunningIndex < sizeLeft) {
				array[beginOfMergedArrayIndex] = left[leftRunningIndex];
				leftRunningIndex++;
				beginOfMergedArrayIndex++;
			}
		}
	}

}
