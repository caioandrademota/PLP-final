import java.util.Observable;
import java.util.Observer;

//Exibição de estatisticas
public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	//Registra o observer
	public StatisticsDisplay(Observable observable) {
		observable.addObserver(this);
	}

	//Realiza a atualização
	public void update(Observable observable, Object arg) {
		//Verifica se é uma instancia de weatherData e realiza a captura da temperatura
		//do weatherData criado, atualizando os dados.
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings++;

			//Verifica se a temperatura atualizada é maior que a maxima e atribui caso seja
			if (temp > maxTemp) {
				maxTemp = temp;
			}
 
			//Verifica se a temperatura atualizada é menor que a minima e atribui caso seja
			if (temp < minTemp) {
				minTemp = temp;
			}

			display();
		}
	}

	//Impressão das temperaturas
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}