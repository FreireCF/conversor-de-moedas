package br.com.conversor;

import br.com.conversor.Models.*;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var scanner = new Scanner(System.in);
        var menu = new Menu();
        var apiKey = System.getenv("API_KEY");
        var gson = new GsonBuilder().setPrettyPrinting().create();
        var from = "";
        var to = "";
        var amount = 0.0;
        var opc = "";

        while (!opc.equalsIgnoreCase("sair")) {
            menu.display();
            System.out.println("\nDigite uma opção: ");
            opc = scanner.nextLine();

            if(opc.equalsIgnoreCase("sair")) {
                break;
            }

            switch (Integer.valueOf(opc)){
                case 1:
                    from = "BRL";
                    to = "USD";
                    System.out.println("Digite o valor para conversão: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                case 2:
                    from = "USD";
                    to = "BRL";
                    System.out.println("Digite o valor para conversão: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                case 3:
                    from = "BRL";
                    to = "EUR";
                    System.out.println("Digite o valor para conversão: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                case 4:
                    from = "EUR";
                    to = "BRL";
                    System.out.println("Digite o valor para conversão: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                case 5:
                    from = "USD";
                    to = "EUR";
                    System.out.println("Digite o valor para conversão: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                case 6:
                    from = "EUR";
                    to = "USD";
                    System.out.println("Digite o valor para conversão: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Escolha um opção válida");
                        break;
            }

            var adress = "https://api.fastforex.io/convert?from=" + from + "&to=" + to + "&amount=" +amount + "&api_key=" + apiKey;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(adress)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            //System.out.println(json);

            var temp = gson.fromJson(json, ExchangerateResponse.class);
            System.out.println(temp);

        }
        scanner.close();
    }
}