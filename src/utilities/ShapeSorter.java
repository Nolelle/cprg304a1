package utilities;

import java.util.Comparator;

public class ShapeSorter<T extends Comparable<T>> {

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

	public void quickSort(T[] shapes, Comparator<T> comparator) {
		quickSort(shapes, 0, shapes.length - 1, comparator);
	}

	private void quickSort(T[] shapes, int low, int high, Comparator<T> comparator) {
		if (low < high) {
			int pivotIndex = partition(shapes, low, high, comparator);
			quickSort(shapes, low, pivotIndex - 1, comparator);
			quickSort(shapes, pivotIndex + 1, high, comparator);
		}
	}

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