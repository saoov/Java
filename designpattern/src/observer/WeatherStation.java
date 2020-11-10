package observer;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay1 = new CurrentConditionsDisplay(weatherData);	 //arraylist에 추가되는 registerObserver가 생성자로 있음
		ForecastDisplay currentDisplay2 = new ForecastDisplay(weatherData);						//arraylist에 추가되는 registerObserver가 생성자로 있음
		StatisticsDisplay currentDisplay3 = new StatisticsDisplay(weatherData);					//arraylist에 추가되는 registerObserver가 생성자로 있음
		
		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println();
		weatherData.setMeasurements(82, 70, 29.2f);
		System.out.println();
		weatherData.setMeasurements(78, 90, 29.2f);
		System.out.println();
		weatherData.removeObserver(currentDisplay2);
		System.out.println();
		weatherData.setMeasurements(88, 95, 28.3f);
	}

}