import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequestingBasic {
    public static void main(String args[]) {
        // Creating a HttpClient object
        HttpClient client = HttpClient.newHttpClient();

        // Creating a HttpRequest object
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/V-Jash"))
                .header("User-Agent", "MyJavaApp/1.0").build();
        try {
            // Creating a HttpResponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code:" + response.statusCode());
            System.out.println("Body:" + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}