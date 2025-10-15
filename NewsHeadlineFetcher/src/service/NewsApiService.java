import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import models.*;
import com.google.gson.Gson;

public class NewsApiService {
    public NewsResponse fetchTopHeadlines() {
        // Creating a Http client with the default settings
        HttpClient client = HttpClient.newHttpClient();

        // Creating a Http Request to fetch the data from the News Api
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://newsapi.org/v2/top-headlines?country=in"))
                .header("Authorization", "96835daf9c2548f8ba8b61a47429712c").build();

        // Creating a Http response to store the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();

        return gson.fromJson(response.body(), NewsResponse.class);

    }

}
