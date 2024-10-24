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

		for (int i = 0; i < n - 1; i++) {
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
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
		// To Do
	}

	/**
	 * Quick sort implementation for Shape arrays Time Complexity: O(n log n)
	 * average, O(n²) worst case Space Complexity: O(log n)
	 * 
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
		// To Do
	}

	/**
	 * Heap sort implementation for Shape arrays (custom sort algorithm) Time
	 * Complexity: O(n log n) Space Complexity: O(1)
	 * 
	 * @param shapes     array of shapes to sort
	 * @param comparator comparator to determine ordering
	 */
	public static void heapSort(Shape[] shape, Comparator<Shape> comparator) {

	}

}
