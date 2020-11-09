package strategypattern;

//���� ���� �������̽��� ���� Ŭ����
interface FlyBehavior {
	void fly();
}

class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("������ ���ƴٴѴ�");
	}
}

class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("�� �� ����.");
	}
}

class FlyRocketPowered implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("���� �������� ���ư��ϴ�.");
	}
}

//��� ���� �������̽��� ���� Ŭ����
interface QuackBehavior {
	void quack();
}

class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("�в�");
	}
}

class SQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("���");
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
		System.out.println("��� ������ ���� ���");
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
		System.out.println("Mallard �����Դϴ�.");
	}
}

class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		System.out.println("���������Դϴ�.");
	}
}
