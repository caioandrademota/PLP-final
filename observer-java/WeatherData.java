import java.util.Observable;
	
public class WeatherData extends Observable {
	//atributos
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() { }
	
	//Defini/valida as mudanças nas medidas notificando os observers
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	//Define as medidades 
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	//Captura da temperatura
	public float getTemperature() {
		return temperature;
	}
	
	//Captura da humidade
	public float getHumidity() {
		return humidity;
	}
	
	//Captura da pressão
	public float getPressure() {
		return pressure;
	}
}