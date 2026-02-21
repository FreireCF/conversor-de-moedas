package br.com.conversor.ConversionStrategy;

import br.com.conversor.ConversionStrategy.ConversionStrategy;

public class BrlToEur implements ConversionStrategy {
    @Override
    public String getFrom() {
        return "BRL";
    }
    @Override
    public String getTo(){
        return "EUR";
    }
}
