package com.projearq.sistemavendas.negocio.repositorios;

import com.projearq.sistemavendas.negocio.entidades.Produto;

import java.util.List;

public interface IProdutosRepository {

	List<Produto> consultaProdutos();

}
