package shapes;

/**
 * Class representing a cylinder shape
 * Base area = πr²
 * Volume = πr²h
 */

public class Cylinder extends Shape {
	private double radius;

	 /**
     * Constructs a cylinder with given height and radius
     * @param height the height of the cylinder
     * @param radius the radius of the cylinder base
     */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	 /**
     * Get the radius of the cylinder
     * @return radius of the cylinder
     */
	public double getRadius() {
		return this.radius;
	}

	/**
     * Calculate the base area of the cylinder using πr²
     * @return base area of the cylinder
     */
	@Override
	public double calcBaseArea() {
		return Math.PI * radius * radius;
	}

	/**
     * Calculate the volume of the cylinder using πr²h
     * @return volume of the cylinder
     */
	@Override
	public double calcVolume() {
		return Math.PI * radius * radius * height;
	}
}
