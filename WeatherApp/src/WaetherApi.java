import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import model.*;
import com.google.gson.Gson;

public class WaetherApi {
    public static void main(String args[]) {
        try {
            // Creating a http client to make requests and gather the responses with default
            // features
            HttpClient client = HttpClient.newHttpClient();

            // Creating a http request to gather information from the open source weather
            // Api.
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
                    "https://api.open-meteo.com/v1/forecast?latitude=17.3850&longitude=78.4867&current_weather=true"))
                    .build();

            // Creating a http response to gather information the external platform
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            WeatherResponse weather = gson.fromJson(response.body(), WeatherResponse.class);
            System.out.println("### WEATHER REPORT ###");
            System.out.println("Latitude : " + weather.latitude);
            System.out.println("Longitude : " + weather.longitude);
            System.out.println("Time : " + weather.current_weather.time);
            System.out.println("Wind Speed : " + weather.current_weather.windspeed);
            System.out.println("Wind Direction : " + weather.current_weather.winddirection);
            System.out.println("Temperature : " + weather.current_weather.temperature);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
