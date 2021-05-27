package com.projearq.sistemavendas.negocio.strategy;

import com.projearq.sistemavendas.aplicacao.dtos.ProdutoDTO;

import java.util.List;

public interface ICalculoImpostoStrategy {

    Integer calculaValorDoImposto(List<ProdutoDTO> itens, double subtotal);

}
