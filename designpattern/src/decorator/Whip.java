package decorator;

public class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + "+ Whip(0.1)";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
