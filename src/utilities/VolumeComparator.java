/**
 * 
 */
package utilities;

import java.util.Comparator;

import shapes.Shape;

/**
 * 
 */
public class VolumeComparator implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		double vol1 = s1.calcVolume();
		double vol2 = s2.calcVolume();

		if (vol1 > vol2) {
			return 1;
		} else if (vol1 < vol2) {
			return -1;
		} else {
			return 0;
		}
	}
}
