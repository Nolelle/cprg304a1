package shapes;

/**
 * Class representing a square prism Base area = s² Volume = s²h
 */
public class SquarePrism extends Prism {

	/**
	 * Constructs a square prism with given height and side length
	 *
	 * @param height the height of the prism
	 * @param side the side length of the prism's base
	 * @throws IllegalArgumentException if height or side is not positive
	 */
	public SquarePrism(double height, double side) {
		super(side, height);
	}

	/**
	 * Calculate the base area of the square prism using s²
	 *
	 * @return base area of the square prism
	 */
	@Override
	public double calcBaseArea() {
		return side * side;
	}

	/**
	 * Calculate the volume of the square prism using s²h
	 *
	 * @return volume of the square prism
	 */
	@Override
	public double calcVolume() {
		return side * side * height;
	}
}
