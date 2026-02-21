package br.com.conversor.ConversionStrategy;

import br.com.conversor.Models.ConversionStrategy;

public class UsdToBrl implements ConversionStrategy {
    @Override
    public String getFrom(){
        return "USD";
    }

    @Override
    public String getTo(){
        return "BRL";
    }
}