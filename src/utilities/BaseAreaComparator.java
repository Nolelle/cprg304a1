/**
 * 
 */
package utilities;

import java.util.Comparator;

import shapes.Shape;


/**
 * Comparator implementation for comparing shapes by base area
 * Implements descending order comparison (larger to smaller)
 */
public class BaseAreaComparator implements Comparator<Shape>{

	 /**
     * Compares two shapes by base area in descending order
     * @param s1 the first shape
     * @param s2 the second shape
     * @return positive if s1 has smaller base area, negative if larger, 0 if equal
     */
	
	@Override
	public int compare(Shape s1, Shape s2) {
        return -Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
	}
}
