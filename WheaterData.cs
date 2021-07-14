using System;
using System.Collections.Generic;

public class WeatherData : Subject
{
    private List<Observer> observers;
    private float temperature;
    private float pressure;
    private float humidity;

    public WeatherData(float temperature, float pressure, float humidity)
    {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.observers = new List<Observer>();
    }

    public void RegisterObserver(Observer observer)
    {
        this.observers.Add(observer);
    }

    public void RemoveObserver (Observer observer)
    {
        this.observers.Remove(observer);
    }

    public void NotifyObservers()
    {
        foreach (Observer observer in this.observers)
        {
            observer.Update(this.temperature, this.pressure, this.humidity);
        }
    }

    public void SetMeasurements(float temperature, float pressure, float humidity)
    {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.NotifyObservers();
    }
}


interface DisplayElement
{
  void Display();
}

interface Subject
{
    void RegisterObserver(Observer observer);
    void RemoveObserver(Observer observer);
    void NotifyObservers();
}

public abstract class Observer
{
    public abstract void Update(float temperature, float pressure, float humidity);
}

public class CurrentConditionsDisplay : Observer , DisplayElement
{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData)
    {
        this.weatherData = weatherData;
        this.weatherData.RegisterObserver(this);
        
    }

    public override void Update(float temperature, float pressure, float humidity)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.Display();
    }


    public void Display()
    {
        Console.WriteLine("Current Conditions: " + this.temperature.ToString() +
         "C degrees and "+ this.humidity.ToString() +"% humidity");
    }
}

class Program
{
    static void Main(string[] args)
    {
        WeatherData wd = new WeatherData(30f, 10f, 90f);
        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(wd);
        wd.SetMeasurements(30f, 10f, 90f);
        wd.SetMeasurements(40f, 20f, 90f);
        wd.SetMeasurements(29f, 15f, 90f);
    }
}
