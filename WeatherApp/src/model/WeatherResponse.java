package model;

public class WeatherResponse {
    String latitude;
    String longitude;
    WeatherReport current_weather;

}

class WeatherReport {
    String time;
    double temperature;
    double windspeed;
    double winddirection;
}
