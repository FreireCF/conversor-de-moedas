package br.com.conversor.ConversionStrategy;

import br.com.conversor.Models.ConversionStrategy;

public class UsdToEur implements ConversionStrategy {
    @Override
    public String getFrom(){
        return "USD";
    }

    @Override
    public String getTo(){
        return "EUR";
    }
}
