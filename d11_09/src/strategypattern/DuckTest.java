package strategypattern;

public class DuckTest {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		
		Duck model = new ModelDuck();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		model.performQuack();

	}

}
