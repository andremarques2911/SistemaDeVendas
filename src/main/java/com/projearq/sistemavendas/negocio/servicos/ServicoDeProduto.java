package com.projearq.sistemavendas.negocio.servicos;

import com.projearq.sistemavendas.negocio.entidades.Produto;
import com.projearq.sistemavendas.negocio.repositorios.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoDeProduto {

	private IProdutosRepository produtosRepository;

	@Autowired
	public ServicoDeProduto(IProdutosRepository produtosRepository) {
		this.produtosRepository = produtosRepository;
	}

	public List<Produto> consultaProduto() {
		return this.produtosRepository.consultaProdutos();
	}

}
