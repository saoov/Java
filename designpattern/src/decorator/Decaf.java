package decorator;

public class Decaf extends Beverage {

	public Decaf() {
		description = "디카페인(0.88)";
	}

	@Override
	public double cost() {
		return .88;
	}

}
