import java.util.Observable;

public class WeatherStation {

	public static void main(String[] args) {
		//Cria o objeto
		WeatherData weatherData = new WeatherData();
		
		//Instancia das classes de exibição
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		//Defini as medidas
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}