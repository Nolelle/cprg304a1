package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Comparator implementation for comparing shapes by volume Implements
 * descending order comparison (larger to smaller)
 */
public class VolumeComparator implements Comparator<Shape> {

	/**
	 * Default constructor
	 */
	public VolumeComparator() {
		// Default constructor
	}

	/**
	 * Compares two shapes by volume in descending order
	 *
	 * @param s1 the first shape
	 * @param s2 the second shape
	 * @return positive if s1 has smaller volume, negative if larger, 0 if
	 * equal
	 */
	@Override
	public int compare(Shape s1, Shape s2) {
		//Negating the comparison for descending order
		return -Double.compare(s1.calcVolume(), s2.calcVolume());
	}
}
