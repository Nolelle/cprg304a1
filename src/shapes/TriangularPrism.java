package shapes;

/**
 * Class representing a triangular prism with equilateral triangle base
 * Base area = (s²√3)/4
 * Volume = ((s²√3)/4)h
 */
public class TriangularPrism extends Prism {

	   /**
     * Constructs a triangular prism with given height and base side length
     * @param height the height of the prism
     * @param side the side length of the prism's base
     */
	public TriangularPrism(double height, double side) {
		super(height, side);
	}


	  /**
     * Calculate the base area of the triangular prism using (s²√3)/4
     * @return base area of the triangular prism
     */
	@Override
	public double calcBaseArea() {
		return (side * side * Math.sqrt(height)) / 4;
	}

	/**
     * Calculate the volume of the triangular prism using base area * height
     * @return volume of the triangular prism
     */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
