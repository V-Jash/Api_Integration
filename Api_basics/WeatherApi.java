import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class WeatherApi {
    public static void main(String args[]) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
                "https://api.open-meteo.com/v1/forecast?latitude=17.3850&longitude=78.4867&current_weather=true"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            WeatherR weather = gson.fromJson(response.body(), WeatherR.class);
            System.out.println("### Weather Report ###");
            System.out.println("Latitude :" + weather.latitude);
            System.out.println("Longitude :" + weather.longitude);
            System.out.println("Time :" + weather.subClass.time);
            System.out.println("Temperature :" + weather.subClass.temperature);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class WeatherR {
    public String longitude;
    public String latitude;
    WeatherSub current_weather;
}

class WeatherSub {
    String time;
    double temperature;
}