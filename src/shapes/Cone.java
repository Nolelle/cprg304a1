package shapes;

/**
 * Class representing a cone shape
 * Base area = πr²
 * Volume = (1/3)πr²h
 */
public class Cone extends Shape {
	private double radius;

	/**
     * Constructs a cone with given height and radius
     * @param height the height of the cone
     * @param radius the radius of the cone base
     */
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	  /**
     * Get the radius of the cone
     * @return radius of the cone
     */
	public double getRadius() {
		return this.radius;
	}

	/**
     * Calculate the base area of the cone using πr²
     * @return base area of the cone
     */
	@Override
	public double calcBaseArea() {
		return Math.PI * radius * radius;
	}

	 /**
     * Calculate the volume of the cone using (1/3)πr²h
     * @return volume of the cone
     */
	@Override
	public double calcVolume() {
		return (1.0 / 3.0) * Math.PI * radius * radius * height;
	}
}
