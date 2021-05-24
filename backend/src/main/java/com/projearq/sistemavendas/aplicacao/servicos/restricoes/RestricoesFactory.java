package com.projearq.sistemavendas.aplicacao.servicos.restricoes;

import com.projearq.sistemavendas.negocio.strategy.IRestricoesStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class RestricoesFactory {

    private Map<String, IRestricoesStrategy> strategies;
    private final boolean possuiRestricoesAtivas = true;

    @Autowired
    public RestricoesFactory(Set<IRestricoesStrategy> strategySet) {
        this.criaRestricao(strategySet);
    }

    public IRestricoesStrategy restricoes(String nome) {
        return this.possuiRestricoesAtivas ? this.strategies.get(nome) : null;
    }

    private void criaRestricao(Set<IRestricoesStrategy> strategySet) {
        this.strategies = new HashMap<String, IRestricoesStrategy>();
        strategySet.forEach(strategy -> this.strategies.put(strategy.obtemNomeStrategy(), strategy));
    }

}
