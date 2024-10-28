package utilities;

import java.util.Comparator;

import shapes.Shape;

/**
 * Class containing sorting algorithm implementations for Shape arrays All sorts
 * are implemented to sort in descending order
 */
public class ShapeSorter {
	/**
	 * Bubble sort implementation for Shape arrays Time Complexity: O(n²) Space
	 * Complexity: O(1)
	 * 
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < n - 1 - i; j++) {
				if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
					Shape temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Insertion sort implementation for Shape arrays Time Complexity: O(n²) Space
	 * Complexity: O(1)
	 * 
	 * @param shapes:     array of shapes to sort
	 * @param comparator: comparator to determine ordering
	 */
	public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;

		for (int i = 1; i < n - 1; i++) {
			Shape key = shapes[i];
			int j = i - 1;

			while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
				shapes[j + 1] = shapes[j];
				j--;
			}
			shapes[j + 1] = key;
		}
	}

	/**
	 * Selection sort implementation for Shape arrays Time Complexity: O(n²) Space
	 * Complexity: O(1)
	 * 
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(shapes[minIndex], shapes[j]) < 0) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				Shape temp = shapes[i];
				shapes[i] = shapes[minIndex];
				shapes[minIndex] = temp;
			}
		}

	}

	/**
	 * Merge sort implementation for Shape arrays Divides array into two halves,
	 * recursively sorts them and then merges the sorted halves Time Complexity: O(n
	 * log n) Space Complexity: O(n)
	 * 
	 * @param shapes:     array of shapes to sort
	 * @param comparator: comparator to determine ordering
	 */
	public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;
		int mid = n / 2;
		Shape[] left = new Shape[mid];
		Shape[] right = new Shape[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = shapes[i];
		}

		for (int i = mid; i < n; i++) {
			right[i - mid] = shapes[i];
		}

		mergeSort(left, comparator);
		mergeSort(right, comparator);

		merge(shapes, left, right, comparator);
	}

	public static void merge(Shape[] shapes, Shape[] left, Shape[] right, Comparator<Shape> comparator) {
		// i tracks left, j tracks right, k tracks shapes
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (comparator.compare(left[i], right[j]) <= 0) {
				shapes[k++] = left[i++];
			} else {
				shapes[k++] = right[j++];
			}
		}

		while (i < left.length) {
			shapes[k++] = left[i++];
		}

		while (j < right.length) {
			shapes[k++] = right[j++];
		}
	}

	/**
	 * Quick sort implementation for Shape arrays Time Complexity: O(n log n)
	 * average, O(n²) worst case Space Complexity: O(log n)
	 * 
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
		quickSort(shapes, 0, shapes.length - 1, comparator);
	}

	private static void quickSort(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
		if (low < high) {
			int pivotIndex = partition(shapes, low, high, comparator);
			quickSort(shapes, low, pivotIndex - 1, comparator);
			quickSort(shapes, pivotIndex + 1, high, comparator);
		}
	}

	private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
		Shape pivot = shapes[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (comparator.compare(shapes[j], pivot) <= 0) {
				i++;

				Shape temp = shapes[i];
				shapes[i] = shapes[j];
				shapes[j] = temp;
			}
		}

		Shape temp = shapes[i + 1];
		shapes[i + 1] = shapes[high];
		shapes[high] = temp;

		return i + 1;
	}

	/**
	 * Heap sort implementation for Shape arrays (custom sort algorithm) Time
	 * Complexity: O(n log n) Space Complexity: O(1)
	 * 
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void heapSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;

		// n / 2 - 1 is how we find the last non leaf node in a max heap.
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(shapes, n, i, comparator);
		}

		for (int i = n - 1; i > 0; i--) {
			Shape temp = shapes[0];
			shapes[0] = shapes[i];
			shapes[i] = temp;
			heapify(shapes, i, 0, comparator);
		}
	}

	private static void heapify(Shape[] shapes, int n, int i, Comparator<Shape> comparator) {
		// Max Heap: largest value node is at the root of the tree.
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
			Shape temp = shapes[i];
			shapes[i] = shapes[largest];
			shapes[largest] = temp;
			heapify(shapes, n, largest, comparator);
		}

	}

}
