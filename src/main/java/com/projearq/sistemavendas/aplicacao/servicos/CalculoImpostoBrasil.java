package com.projearq.sistemavendas.aplicacao.servicos;

import com.projearq.sistemavendas.negocio.strategy.ICalculoImpostoStrategy;

public class CalculoImpostoBrasil implements ICalculoImpostoStrategy {

    private final double VALOR_IMPOSTO = 0.2;

    @Override
    public Integer calculaValorDoImposto(int subtotal) {
        return (int) (subtotal * VALOR_IMPOSTO);
    }

}
