package shapes;

public class TriangularPrism extends Prism {
	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (side * side * Math.sqrt(height)) / 4;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
