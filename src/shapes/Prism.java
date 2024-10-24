package shapes;

/**
 * Abstract class for all prism shapes
 */
public abstract class Prism extends Shape {
	protected double side;
	
	/**
     * Constructs a prism with given height and side length
     * @param height the height of the prism (must be positive)
     * @param side the side length of the base (must be positive)
     * @throws IllegalArgumentException if side is not positive
     */
	public Prism (double height, double side) {
		super(height);
		if (side <= 0) {
			throw new IllegalArgumentException("Side need to be positive numbers.");
		}
		this.side = side;
	}
	
	/**
     * Get side length of prism
     * @return side length
     */
	public double getSide (double side) {
		return side;
	}
		
	/**
     * Sets the side length of the prism's base
     * @param side the new side length (must be positive)
     * @throws IllegalArgumentException if side is not positive
     */
    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.side = side;
    }
    
    @Override
    public String toString() {
        return String.format("%s {height=%.2f, side=%.2f, baseArea=%.2f, volume=%.2f}", 
                this.getClass().getSimpleName(), height, side, calcBaseArea(), calcVolume());
        }
}
