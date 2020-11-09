package strategypattern;

//나는 동작 인터페이스와 구현 클래스
interface FlyBehavior {
	void fly();
}

class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("날개로 날아다닌다");
	}
}

class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("날 수 없다.");
	}
}

class FlyRocketPowered implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("로켓 추진으로 날아갑니다.");
	}
}

//우는 동작 인터페이스와 구현 클래스
interface QuackBehavior {
	void quack();
}

class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("꽥꽥");
	}
}

class SQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("삑삑");
	}
}

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	abstract void display();

	void performFly() {
		flyBehavior.fly();
	}

	void performQuack() {
		quackBehavior.quack();
	}

	void swim() {
		System.out.println("모든 오리는 물에 뜬다");
	}

	void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}

class MallardDuck extends Duck {
	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		System.out.println("Mallard 오리입니다.");
	}
}

class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		System.out.println("모형오리입니다.");
	}
}
