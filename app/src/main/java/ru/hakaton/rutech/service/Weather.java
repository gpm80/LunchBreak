package ru.hakaton.rutech.service;

public class Weather {
    private WeatherEnum weatherEnum;
    private int temperature;

    public Weather(WeatherEnum weatherEnum, int temperature) {
        this.weatherEnum = weatherEnum;
        this.temperature = temperature;
    }

    public WeatherEnum getWeatherEnum() {
        return weatherEnum;
    }

    public void setWeatherEnum(WeatherEnum weatherEnum) {
        this.weatherEnum = weatherEnum;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
