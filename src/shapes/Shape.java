/**
 * 
 */
package shapes;

/**
 * 
 */
public abstract class Shape implements Comparable<Shape> {
	//Member
	protected double height;
	
	//Constructor
	public Shape (double height) {
		this.height = height;
	}

	// Getters and Setters
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	// Abstract methods
	public abstract double calcBaseArea;
	public abstract double calcVolume;
	
	
	// Override the compareTo method from the Comparable interface.
	@Override
	public int compareTo(Shape other) {
		if (this.height > other.height) return 1;
		 else if (this.height < other.height) return -1;
		return 0;
	} 
}
