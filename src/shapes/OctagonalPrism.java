package shapes;

/**
 * Class representing an octagonal prism
 * Base area = 2(1 + √2)s²
 * Volume = 2(1 + √2)s²h
 */
public class OctagonalPrism extends Prism {
	  /**
     * Constructs an octagonal prism with given height and base side length
     * @param height the height of the prism
     * @param side the side length of the prism's base
     */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	 /**
     * Calculate the base area of the octagonal prism using 2(1 + √2)s²
     * @return base area of the octagonal prism
     */
	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * side * side;
	}


	 /**
     * Calculate the volume of the octagonal prism using base area * height
     * @return volume of the octagonal prism
     */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
