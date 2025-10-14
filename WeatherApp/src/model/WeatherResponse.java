package model;

public class WeatherResponse {
    public String latitude;
    public String longitude;
    WeatherReport current_weather;

}

class WeatherReport {
    public String time;
    public double temperature;
    public double windspeed;
    public double winddirection;
}
