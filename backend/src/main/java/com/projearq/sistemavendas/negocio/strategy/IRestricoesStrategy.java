package com.projearq.sistemavendas.negocio.strategy;

public interface IRestricoesStrategy {

    boolean restringeQuantidadeItensVenda(int quantidadeItensVenda);

    boolean restringeQuantidadeItem(int quantidadeItem);

    boolean restringeValorTotalVenda(int valorTotalVenda);

    String obtemNomeStrategy();

}
