import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SentimentAnalysis {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program is all about the Sentiment Analysis :");
        System.out.println("Enter the String :");
        String text = scan.nextLine();
        String formData = "text=" + URLEncoder.encode(text, StandardCharsets.UTF_8);

        // Creating a HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Creating a HttpRequest
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://text-processing.com/api/sentiment/"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(formData)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code :" + response.statusCode());
        System.out.println("Response body :" + response.body());

    }
}
