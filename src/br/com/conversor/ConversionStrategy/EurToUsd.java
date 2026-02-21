package br.com.conversor.ConversionStrategy;

import br.com.conversor.ConversionStrategy.ConversionStrategy;

public class EurToUsd implements ConversionStrategy {
    @Override
    public String getFrom(){
        return "EUR";
    }

    @Override
    public String getTo(){
        return "USD";
    }
}