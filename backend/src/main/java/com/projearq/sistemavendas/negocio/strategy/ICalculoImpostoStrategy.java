package com.projearq.sistemavendas.negocio.strategy;

public interface ICalculoImpostoStrategy {

    Integer calculaValorDoImposto(List<ProdutoDTO> itens);

}
