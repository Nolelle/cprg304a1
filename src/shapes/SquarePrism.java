package shapes;


/**
 * Class representing a square prism
 * Base area = s²
 * Volume = s²h
 */
public class SquarePrism extends Prism {
	 /**
     * Constructs a shape with the given height
     * @param height the height of the shape (must be positive)
     * @throws IllegalArgumentException if height is not positive
     */
	public SquarePrism(double height, double side) {
		super(side, height);
	}
	
	 /**
     * Calculate the base area of the square prism using s²
     * @return base area of the square prism
     */
	@Override
	public double calcBaseArea() {
		return side * side;
	}

	 /**
     * Calculate the volume of the square prism using s²h
     * @return volume of the square prism
     */
	@Override
	public double calcVolume() {
		return side * side * height;
	}
}
