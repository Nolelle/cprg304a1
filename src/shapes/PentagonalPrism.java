package shapes;

public class PentagonalPrism extends Prism {
	public PentagonalPrism(double side, double height) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (5 * side * side * Math.tan(Math.toRadians(54)))) / 4;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
