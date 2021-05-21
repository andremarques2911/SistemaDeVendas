package com.projearq.sistemavendas.negocio.repositorios;

import com.projearq.sistemavendas.negocio.entidades.Estoque;

public interface IEstoqueRepository {

	Estoque buscaItemEstoque(Long codigo);

	Estoque adicionaEstoqueProduto(Estoque estoque);

}
