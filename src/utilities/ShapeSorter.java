package utilities;

import java.util.Comparator;

/**
 * Generic sorting class that implements various sorting algorithms for arrays
 * of Comparable objects. All sorts are implemented to sort in descending order.
 * 
 * @param <T> type that implements Comparable interface
 */
public class ShapeSorter<T extends Comparable<T>> {

	/**
	 * Bubble sort implementation. Repeatedly steps through the list, compares
	 * adjacent elements and swaps them if they are in the wrong order. Time
	 * Complexity: O(n²) Space Complexity: O(1)
	 * 
	 * @param shapes     array to be sorted
	 * @param comparator comparator to determine ordering
	 */
	public void bubbleSort(T[] shapes, Comparator<T> comparator) {
		int n = shapes.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (comparator.compare(shapes[j], shapes[j + 1]) < 0) {
					T temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Insertion sort implementation. Builds final sorted array one item at a time
	 * by repeatedly taking next element and inserting it into its correct position.
	 * Time Complexity: O(n²) Space Complexity: O(1)
	 * 
	 * @param shapes     array to be sorted
	 * @param comparator comparator to determine ordering
	 */

	public void insertionSort(T[] shapes, Comparator<T> comparator) {
		int n = shapes.length;

		for (int i = 1; i < n; i++) {
			T key = shapes[i];
			int j = i - 1;

			while (j >= 0 && comparator.compare(shapes[j], key) < 0) {
				shapes[j + 1] = shapes[j];
				j--;
			}
			shapes[j + 1] = key;
		}
	}

	/**
	 * Selection sort implementation. Divides input into sorted and unsorted
	 * regions, repeatedly finds minimum element from unsorted region and adds it to
	 * sorted region. Time Complexity: O(n²) Space Complexity: O(1)
	 * 
	 * @param shapes     array to be sorted
	 * @param comparator comparator to determine ordering
	 */
	public void selectionSort(T[] shapes, Comparator<T> comparator) {
		int n = shapes.length;

		for (int i = 0; i < n - 1; i++) {
			int maxIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(shapes[j], shapes[maxIndex]) > 0) {
					maxIndex = j;
				}
			}

			if (maxIndex != i) {
				T temp = shapes[i];
				shapes[i] = shapes[maxIndex];
				shapes[maxIndex] = temp;
			}
		}
	}

	/**
	 * Merge sort implementation. Divides input array into two halves, recursively
	 * sorts them, then merges the sorted halves. Time Complexity: O(n log n) Space
	 * Complexity: O(n)
	 * 
	 * @param shapes     array to be sorted
	 * @param comparator comparator to determine ordering
	 */
	public void mergeSort(T[] shapes, Comparator<T> comparator) {
		if (shapes.length < 2) {
			return;
		}

		int mid = shapes.length / 2;
		T[] left = (T[]) new Comparable[mid];
		T[] right = (T[]) new Comparable[shapes.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = shapes[i];
		}

		for (int i = mid; i < shapes.length; i++) {
			right[i - mid] = shapes[i];
		}

		mergeSort(left, comparator);
		mergeSort(right, comparator);
		merge(shapes, left, right, comparator);
	}

	/**
	 * Helper method for merge sort. Merges two sorted arrays into a single sorted
	 * array.
	 * 
	 * @param shapes     destination array
	 * @param left       first sorted array
	 * @param right      second sorted array
	 * @param comparator comparator to determine ordering
	 */
	private void merge(T[] shapes, T[] left, T[] right, Comparator<T> comparator) {
		int i = 0, j = 0, k = 0;
		int leftLength = left.length;
		int rightLength = right.length;

		while (i < leftLength && j < rightLength) {
			if (comparator.compare(left[i], right[j]) >= 0) {
				shapes[k] = left[i];
				i++;
			} else {
				shapes[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < leftLength) {
			shapes[k] = left[i];
			i++;
			k++;
		}

		while (j < rightLength) {
			shapes[k] = right[j];
			j++;
			k++;
		}
	}

	/**
	 * Quick sort implementation. Selects a 'pivot' element and partitions other
	 * elements into two sub-arrays according to whether they are less than or
	 * greater than the pivot. Time Complexity: O(n log n) average case, O(n²) worst
	 * case Space Complexity: O(log n)
	 * 
	 * @param shapes     array to be sorted
	 * @param comparator comparator to determine ordering
	 */
	public void quickSort(T[] shapes, Comparator<T> comparator) {
		quickSortRecursive(shapes, 0, shapes.length - 1, comparator);
	}

	/**
	 * Recursive helper method for quick sort.
	 * 
	 * @param shapes     array to be sorted
	 * @param low        starting index of the subarray
	 * @param high       ending index of the subarray
	 * @param comparator comparator to determine ordering
	 */
	private void quickSortRecursive(T[] shapes, int low, int high, Comparator<T> comparator) {
		if (low < high) {
			int pivotIndex = partition(shapes, low, high, comparator);
			quickSortRecursive(shapes, low, pivotIndex - 1, comparator);
			quickSortRecursive(shapes, pivotIndex + 1, high, comparator);
		}
	}

	/**
	 * Helper method for quick sort that partitions the array. Places pivot at its
	 * correct position in sorted array and places all smaller elements to left of
	 * pivot, and all greater elements to right of pivot.
	 * 
	 * @param shapes     array to be partitioned
	 * @param low        starting index of the subarray
	 * @param high       ending index of the subarray
	 * @param comparator comparator to determine ordering
	 * @return the partitioning index
	 */
	private int partition(T[] shapes, int low, int high, Comparator<T> comparator) {
		T pivot = shapes[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (comparator.compare(shapes[j], pivot) >= 0) {
				i++;
				T temp = shapes[i];
				shapes[i] = shapes[j];
				shapes[j] = temp;
			}
		}

		T temp = shapes[i + 1];
		shapes[i + 1] = shapes[high];
		shapes[high] = temp;
		return i + 1;
	}

	/**
	 * Heap sort implementation. Creates a max heap of the array and repeatedly
	 * extracts the maximum element. Time Complexity: O(n log n) Space Complexity:
	 * O(1)
	 * 
	 * @param shapes     array to be sorted
	 * @param comparator comparator to determine ordering
	 */
	public void heapSort(T[] shapes, Comparator<T> comparator) {
		int n = shapes.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(shapes, n, i, comparator);
		}

		for (int i = n - 1; i > 0; i--) {
			T temp = shapes[0];
			shapes[0] = shapes[i];
			shapes[i] = temp;
			heapify(shapes, i, 0, comparator);
		}
	}

	/**
	 * Helper method for heap sort that heapifies a subtree rooted with node i.
	 * Assumes that the subtrees are already heapified.
	 * 
	 * @param shapes     array representing heap
	 * @param n          size of heap
	 * @param i          root node of subtree
	 * @param comparator comparator to determine ordering
	 */
	private void heapify(T[] shapes, int n, int i, Comparator<T> comparator) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && comparator.compare(shapes[left], shapes[largest]) > 0) {
			largest = left;
		}

		if (right < n && comparator.compare(shapes[right], shapes[largest]) > 0) {
			largest = right;
		}

		if (largest != i) {
			T temp = shapes[i];
			shapes[i] = shapes[largest];
			shapes[largest] = temp;
			heapify(shapes, n, largest, comparator);
		}
	}
}