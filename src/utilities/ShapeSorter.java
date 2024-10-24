/**
 * 
 */
package utilities;

import java.util.Comparator;

import shapes.Shape;

/**
 * 
 */
public class ShapeSorter {
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - 1- i; j++) {
				if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
					Shape temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] =  temp;
				}
			}
		}
	}

	public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
		// To Do
	}

	public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
		// To Do
	}

	public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
		// To Do
	}

	public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
		// To Do
	}

	public static void heapSort(Shape[] shape, Comparator<Shape> comparator) {

	}

}
