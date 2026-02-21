package br.com.conversor.Models;

import java.util.Map;

public record ExchangerateResponse (String base, double amount, Map<String, Double> result){
    @Override
    public String toString() {
        var targetCurrency = result.keySet() //pega as chaves do Map
            .stream() //tranforma as chaves em .stream para usar o .filter
            .filter(k -> !k.equals("rate")) //pega apenas o que não é rate (só a moeda)
            .findFirst() //pega o primeiro elemnto da stream após o filtro
            .orElse("Desconhecida"); //se n existe

        var convertedAmount = result.getOrDefault(targetCurrency, 0.0);
        var rate = result.getOrDefault("rate", 0.0);

        return """
            %.2f %s → %.2f %s
            Taxa: %.4f
            """.formatted(
                amount,
                base,
                convertedAmount,
                targetCurrency,
                rate
        );
    }
}