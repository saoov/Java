package observer;

import java.util.ArrayList;

interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObservers();
}

public class WeatherData implements Subject {
	// member field
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	// constructor
	public WeatherData() {
		observers = new ArrayList<>();
	}

	// methods
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	// ���¿� ���ؼ� ��� ������������ �˷��ִ� �κ�. ��� Observer�������̽��� �����ϴ� ��ü���̹Ƿ� ���� �˷��ֱ� ����.
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}

interface Observer {
	void update(float temp, float humidity, float pressure);  //�Ϲ������� �Ű������� Subject Ÿ���� �������� ���⼱ Subject�� ��������� �޾ƿ�
}

interface DisplayElement {
	void display();
}
