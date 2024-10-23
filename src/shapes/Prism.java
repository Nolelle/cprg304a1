/**
 * 
 */
package shapes;

/**
 * 
 */
public class Prism extends Shape {
	protected double side;
	
	public Prism (double height, double side) {
		super(height);
		this.side = side;
	}
	
	public double getSide (double side) {
		return side;
	}
		
	public void setSide (double side) {
		 this.side = side;
	}
}
