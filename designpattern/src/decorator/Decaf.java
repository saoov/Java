package decorator;

public class Decaf extends Beverage {

	public Decaf() {
		description = "��ī����(0.88)";
	}

	@Override
	public double cost() {
		return .88;
	}

}
