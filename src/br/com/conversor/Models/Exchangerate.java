package br.com.conversor.Models;

import java.util.Map;

public class Exchangerate {
    private String base;
    private double amount;
    private Map<String, Double> result;

    public Exchangerate(ExchangerateResponse response){
        this.base = response.base();
        this.amount = response.amount();
        this.result = response.result();
    }
}