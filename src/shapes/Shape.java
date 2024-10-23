/**
 * 
 */
package shapes;

/**
 * 
 */
public class Shape implements Comparable<Shape> {
	private double height;
	
	public Shape (double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public abstract double calcBaseArea;
	public abstract double calcVolume;
	
	
	@Override
	public int compareTo(Shape other) {
		if (this.height > other.height) return 1;
		 else if (this.height < other.height) return -1;
		return 0;
	} 
}
