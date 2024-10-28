package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilities.AreaComparator;
import utilities.ShapeSorter;
import utilities.VolumeComparator;

public class AppDriver {
	private static String filename;
	private static char compareType;
	private static char sortType;

	public static void main(String[] args) {
		if (!parseArgs(args)) {
			System.exit(1);
		}

		try {
			Shape[] shapes = readShapesFromFile();
			Comparator<Shape> comparator = switch (compareType) {
			case 'h' -> null; // Use natural ordering (height)
			case 'a' -> new AreaComparator();
			case 'v' -> new VolumeComparator();
			default -> throw new IllegalArgumentException("Invalid compare type: " + compareType);
			};

			// Create instance of ShapeSorter for Shape type
			ShapeSorter<Shape> sorter = new ShapeSorter<>();

			// Sort and measure time
			long startTime = System.nanoTime();

			// Execute requested sort using instance methods
			switch (sortType) {
			case 'b' -> sorter.bubbleSort(shapes, comparator);
			case 'i' -> sorter.insertionSort(shapes, comparator);
			case 's' -> sorter.selectionSort(shapes, comparator);
			case 'm' -> sorter.mergeSort(shapes, comparator);
			case 'q' -> sorter.quickSort(shapes, comparator);
			case 'z' -> sorter.heapSort(shapes, comparator);
			default -> throw new IllegalArgumentException("Invalid sort type: " + sortType);
			}

			long endTime = System.nanoTime();

			System.out.printf("Sort completed in %.2f milliseconds%n", (endTime - startTime) / 1_000_000.0);
			printResults(shapes);

		} catch (FileNotFoundException e) {
			System.err.println("Error: Could not find file " + filename);
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}

	private static boolean parseArgs(String[] args) {
		if (args.length != 3) {
			System.err.println("Error: Exactly three arguments are required");
			return false;
		}

		for (String arg : args) {
			if (arg.length() < 2 || arg.charAt(0) != '-') {
				System.err.println("Error: Invalid argument format: " + arg);
				return false;
			}

			char option = Character.toLowerCase(arg.charAt(1));
			String value = arg.substring(2);

			switch (option) {
			case 'f' -> filename = value;
			case 't' -> {
				if (value.length() != 1) {
					System.err.println("Error: Compare type must be a single character");
					return false;
				}
				compareType = Character.toLowerCase(value.charAt(0));
				if ("hva".indexOf(compareType) == -1) {
					System.err.println("Error: Invalid compare type. Must be h, v, or a");
					return false;
				}
			}
			case 's' -> {
				if (value.length() != 1) {
					System.err.println("Error: Sort type must be a single character");
					return false;
				}
				sortType = Character.toLowerCase(value.charAt(0));
				if ("bsimqz".indexOf(sortType) == -1) {
					System.err.println("Error: Invalid sort type. Must be b, s, i, m, q, or z");
					return false;
				}
			}
			default -> {
				System.err.println("Error: Invalid option: " + option);
				return false;
			}
			}
		}
		return true;
	}

	private static Shape[] readShapesFromFile() throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);

		int numShapes = scanner.nextInt();
		Shape[] shapes = new Shape[numShapes];

		for (int i = 0; i < numShapes; i++) {
			String shapeType = scanner.next();
			double height = scanner.nextDouble();
			double dimension = scanner.nextDouble(); // radius or side length

			shapes[i] = switch (shapeType.toLowerCase()) {
			case "cylinder" -> new Cylinder(height, dimension);
			case "cone" -> new Cone(height, dimension);
			case "pyramid" -> new Pyramid(dimension, height);
			case "squareprism" -> new SquarePrism(height, dimension);
			case "triangularprism" -> new TriangularPrism(height, dimension);
			case "pentagonalprism" -> new PentagonalPrism(dimension, height);
			case "octagonalprism" -> new OctagonalPrism(height, dimension);
			default -> throw new IllegalArgumentException("Unknown shape type: " + shapeType);
			};
		}

		scanner.close();
		return shapes;
	}

	private static void printResults(Shape[] shapes) {
		if (shapes.length == 0) {
			System.out.println("No shapes to display");
			return;
		}

		System.out.println("\nSorted Results (Descending Order):");
		for (int i = 0; i < shapes.length; i++) {
			System.out.println("Element " + (i + 1) + ": " + shapes[i]);
		}
	}
}