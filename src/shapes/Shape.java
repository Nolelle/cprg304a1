/**
 *
 */
package shapes;

/**
 * Abstract base class for all 3D shapes Implements Comparable for default
 * height comparison
 */
public abstract class Shape implements Comparable<Shape> {

	/**
	 * The height of the shape
	 */
	protected double height;

	/**
	 * Constructs a shape with the given height
	 *
	 * @param height the height of the shape (must be positive)
	 * @throws IllegalArgumentException if height is not positive
	 */
	public Shape(double height) {
		if (height < 0) {
			throw new IllegalArgumentException("Height must be positive");
		}
		this.height = height;
	}

	/**
	 * Get height of shape
	 *
	 * @return height of shape
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the height of the shape
	 *
	 * @param height the new height (must be positive)
	 * @throws IllegalArgumentException if height is not positive
	 */
	public void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalArgumentException("Height must be positive");
		}
		this.height = height;
	}

	/**
	 * Calculate base area of shape
	 *
	 * @return base area
	 */
	public abstract double calcBaseArea();

	/**
	 * Calculate volume of shape
	 *
	 * @return volume
	 */
	public abstract double calcVolume();

	/**
	 * Compare shapes by height (natural ordering)
	 *
	 * @param s shape to compare with
	 * @return negative if this is less, positive if this is greater, 0 if
	 * equal
	 */
	@Override
	public int compareTo(Shape s) {
		if (this.height > s.height) {
			return 1;
		} else if (this.height < s.height) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * String representation of the shape
	 *
	 * @return string containing the shape type and its dimensions
	 */
	@Override
	public String toString() {
		return String.format("%s {height=%.2f, baseArea=%.2f, volume=%.2f}", this.getClass().getSimpleName(), height,
			calcBaseArea(), calcVolume());
	}
}
