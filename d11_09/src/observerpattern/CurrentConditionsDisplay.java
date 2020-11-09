package observerpattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	
	private float temperatrue;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay (Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}


	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperatrue = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions : " +temperatrue
				+", F degrees and "+humidity+"% humidity");
	}
}
