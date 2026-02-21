package br.com.conversor;

import br.com.conversor.Models.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var scanner = new Scanner(System.in);
        var menu = new Menu();
        var apiResponse = new ExchangerateService();
        var opc = "";
        int numeroOpc;

        while (!opc.equalsIgnoreCase("sair")) {
            menu.display();
            System.out.println("\nDigite uma opção: ");
            opc = scanner.nextLine();

            if(opc.equalsIgnoreCase("sair")) {
                System.out.println("\nEncerrando aplicação");
                break;
            }

            try {
                numeroOpc = Integer.valueOf(opc);
            } catch (NumberFormatException e) {
                System.out.println("\nDigite uma opção válida.");
                continue;
            }

            var strategyFactory = ConversionStrategyFactory.getStrategy(numeroOpc);
            var from = strategyFactory.getFrom();
            var to = strategyFactory.getTo();

            System.out.println("Digite o valor para conversão: ");
            var amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.println(apiResponse.service(from, to, amount));

        }
        scanner.close();
    }
}