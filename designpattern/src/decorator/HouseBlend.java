package decorator;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		description = "�Ͽ콺 ���� Ŀ��(0.89)";
	}

	@Override
	public double cost() {
		return .89;
	}

}
