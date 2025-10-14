import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
