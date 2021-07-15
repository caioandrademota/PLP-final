import java.util.Observable;
import java.util.Observer;

//Exibição de previsoes
public class ForecastDisplay implements Observer, DisplayElement {
	//Pressão atual
	private float currentPressure = 29.92f;  
	//Ultima pressão
	private float lastPressure;

	//Adiciona o observer a lista
	public ForecastDisplay(Observable observable) {
		observable.addObserver(this);
	}

	//Atualiza os dados por atraves das observações
	public void update(Observable observable, Object arg) {
		//Verifica se o objeto observado é uma instancia de weatherData
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			//A última pressão recebe a atual (desatualizada)
			lastPressure = currentPressure;
			//Atualiza a pressão atual com a nova pressão observada no objeto
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	//Função de impressão de saida
	public void display() {
		System.out.print("Forecast: ");
		//Verifica se a ultima temperatura é menor que a atual
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) { //Verifica se as temperaturas são iguais 
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {//Verifica se a ultima temperatura é maior que a atual
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}