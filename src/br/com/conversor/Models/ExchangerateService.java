package br.com.conversor.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangerateService {
    private final String apiKey = System.getenv("API_KEY");
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ExchangerateResponse service(String from, String to, double amount) throws IOException, InterruptedException{
        String adress = "https://api.fastforex.io/convert?from=" + from + "&to=" + to + "&amount=" + amount + "&api_key=" + apiKey;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(adress)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var apiResponse = gson.fromJson(response.body(), ExchangerateResponse.class);

        return apiResponse;
    }
}
