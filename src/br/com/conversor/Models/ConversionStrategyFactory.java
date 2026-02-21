package br.com.conversor.Models;

import br.com.conversor.ConversionStrategy.*;

import java.util.Map;

public class ConversionStrategyFactory {
    private static final Map<Integer, ConversionStrategy> strategies = Map.of(
        1, new BrlToUsd(),
        2, new UsdToBrl(),
        3, new BrlToEur(),
        4, new EurToBrl(),
        5, new UsdToEur(),
        6, new EurToUsd()
    );

    public static ConversionStrategy getStrategy (int opc){
        return strategies.get(opc);
    }
}