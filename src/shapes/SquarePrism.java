package shapes;

public class SquarePrism extends Prism {
	public SquarePrism(double height, double side) {
		super(side, height);
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

	@Override
	public double calcVolume() {
		side * side * height;
	}
}
