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

	// 상태에 대해서 모든 옵저버들한테 알려주는 부분. 모두 Observer인터페이스를 구현하는 객체들이므로 쉽게 알려주기 가능.
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
	void update(float temp, float humidity, float pressure);  //일반적으로 매개변수로 Subject 타입을 가져오나 여기선 Subject의 멤버변수를 받아옴
}

interface DisplayElement {
	void display();
}
