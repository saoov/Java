package decorator;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription()+"+¸ğÄ«(0.2)";
	}

	@Override
	public double cost() {
		return 0.20+beverage.cost();
	}

}
