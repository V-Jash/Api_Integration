package main;

import java.util.*;
import models.*;
import models.NewsResponse;
import service.*;
import java.io.IOException;

public class NewsFetcherApp {
    public static void main(String args[]) throws IOException, InterruptedException {

        NewsResponse response = new NewsApiService().fetchTopHeadlines();
        System.out.println("### Fetching the HeadLines ###");
        System.out.println("Status code :" + response.status);
        System.out.println("The number of responses found are :" + response.totalResults);

    }
}
