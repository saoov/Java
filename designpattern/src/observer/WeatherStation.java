package observer;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay1 = new CurrentConditionsDisplay(weatherData);	 //arraylist�� �߰��Ǵ� registerObserver�� �����ڷ� ����
		ForecastDisplay currentDisplay2 = new ForecastDisplay(weatherData);						//arraylist�� �߰��Ǵ� registerObserver�� �����ڷ� ����
		StatisticsDisplay currentDisplay3 = new StatisticsDisplay(weatherData);					//arraylist�� �߰��Ǵ� registerObserver�� �����ڷ� ����
		
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