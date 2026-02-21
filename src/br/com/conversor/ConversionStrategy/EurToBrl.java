package br.com.conversor.ConversionStrategy;

import br.com.conversor.Models.ConversionStrategy;

public class EurToBrl implements ConversionStrategy {
    @Override
    public String getFrom(){
        return "EUR";
    }

    @Override
    public String getTo(){
        return "BRL";
    }
}