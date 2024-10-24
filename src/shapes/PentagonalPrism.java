package shapes;

/**
 * Class representing a pentagonal prism
 * Base area = (5s²tan(54°))/4
 * Volume = ((5s²tan(54°))/4)h
 */
public class PentagonalPrism extends Prism {
	 /**
     * Constructs a pentagonal prism with given height and base side length
     * @param height the height of the prism
     * @param side the side length of the prism's base
     */
	public PentagonalPrism(double side, double height) {
		super(height, side);
	}

	 /**
     * Calculate the base area of the pentagonal prism using (5s²tan(54°))/4
     * @return base area of the pentagonal prism
     */
	@Override
	public double calcBaseArea() {
		return (5 * side * side * Math.tan(Math.toRadians(54))) / 4;
	}

	 /**
     * Calculate the volume of the pentagonal prism using base area * height
     * @return volume of the pentagonal prism
     */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
