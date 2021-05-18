package com.projearq.sistemavendas.negocio.servicos;

import com.projearq.sistemavendas.negocio.entidades.Venda;
import com.projearq.sistemavendas.negocio.repositorios.IEstoqueRepository;
import com.projearq.sistemavendas.negocio.repositorios.IVendasRepository;
import com.projearq.sistemavendas.negocio.strategy.ICalculoImpostoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ServicoVendas {

	private IEstoqueRepository estoqueRepository;

	private IVendasRepository vendasRepository;

	private ICalculoImpostoStrategy calculoImpostoStrategy;

	@Autowired
	public ServicoVendas(IEstoqueRepository estoqueRepository, IVendasRepository vendasRepository, @Qualifier("opcaoBrasil") ICalculoImpostoStrategy calculoImpostoStrategy) {
		this.estoqueRepository = estoqueRepository;
		this.vendasRepository = vendasRepository;
		this.calculoImpostoStrategy = calculoImpostoStrategy;
	}

	public List<Venda> consultaVendas() {
		return this.vendasRepository.consultaVendas();
	}

	public BigDecimal calculaCustoBasico() {
		return BigDecimal.TEN;
	}

	public boolean efetuarVenda() {
		return false;
	}

}
