package ru.hakaton.rutech.service;

public class WeatherService {
    Weather weather;
    int idWeather;

    public void setWeather() {
        idWeather = (int) (Math.random() * 4);
        switch (idWeather) {
            case 1:
                weather = new Weather(WeatherEnum.Hail, -20 + (int) (Math.random() * 20));
            case 2:
                weather = new Weather(WeatherEnum.Snow, -20 + (int) (Math.random() * 0));
            case 3:
                weather = new Weather(WeatherEnum.Rain, 0 + (int) (Math.random() * 20));
            case 4:
                weather = new Weather(WeatherEnum.Windy, -20 + (int) (Math.random() * 20));
        }
    }
}
