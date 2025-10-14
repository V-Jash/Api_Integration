package model;

public class WeatherResponse {
    public double latitude;
    public double longitude;
    public WeatherReport current_weather;

    public static class WeatherReport {
        public String time;
        public double temperature;
        public double windspeed;
        public double winddirection;
    }
}
