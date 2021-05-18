package com.projearq.sistemavendas.aplicacao.servicos;

import com.projearq.sistemavendas.negocio.strategy.ICalculoImpostoStrategy;

import java.math.BigDecimal;

public class CalculoImpostoBrasil implements ICalculoImpostoStrategy {

    @Override
    public BigDecimal calculaValorDoImposto() {
        return BigDecimal.TEN;
    }

}
