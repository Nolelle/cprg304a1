package shapes;


/**
 * Class representing a pyramid shape with square base
 * Base area = s²
 * Volume = (1/3)s²h
 */
public class Pyramid extends Shape {
	private double side;

	 /**
     * Constructs a pyramid with given height and base side length
     * @param height the height of the pyramid
     * @param side the side length of the pyramid's base
     */
	public Pyramid(double side, double height) {
		super(height);
		this.side = side;
	}
	

	 /**
     * Get the side length of the pyramid's base
     * @return side length of the base
     */
	public double getSide() {
		return this.side;
	}

	
	  /**
     * Calculate the base area of the pyramid using s²
     * @return base area of the pyramid
     */
	@Override
	public double calcBaseArea() {
		return side * side;
	}

	 /**
     * Calculate the volume of the pyramid using (1/3)s²h
     * @return volume of the pyramid
     */
	@Override
	public double calcVolume() {
		return (1.0 / 3.0) * side * side * height;
	}

}
