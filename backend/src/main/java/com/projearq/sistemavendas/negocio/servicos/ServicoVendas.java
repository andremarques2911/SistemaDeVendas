package com.projearq.sistemavendas.negocio.servicos;

import com.projearq.sistemavendas.aplicacao.dtos.ProdutoDTO;
import com.projearq.sistemavendas.negocio.entidades.Estoque;
import com.projearq.sistemavendas.negocio.entidades.ItemVenda;
import com.projearq.sistemavendas.negocio.entidades.Produto;
import com.projearq.sistemavendas.negocio.entidades.Venda;
import com.projearq.sistemavendas.negocio.repositorios.IVendasRepository;
import com.projearq.sistemavendas.negocio.strategy.ICalculoImpostoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ServicoVendas {

	private IVendasRepository vendasRepository;

	private ICalculoImpostoStrategy calculoImpostoStrategy;

	private ServicoDeProduto servicoDeProduto;

	private  ServicoDeEstoque servicoDeEstoque;

	@Autowired
	public ServicoVendas(IVendasRepository vendasRepository, ICalculoImpostoStrategy calculoImpostoStrategy, ServicoDeProduto servicoDeProduto, ServicoDeEstoque servicoDeEstoque) {
		this.vendasRepository = vendasRepository;
		this.calculoImpostoStrategy = calculoImpostoStrategy;
		this.servicoDeProduto = servicoDeProduto;
		this.servicoDeEstoque = servicoDeEstoque;
	}

	public List<Venda> consultaVendas() {
		return this.vendasRepository.consultaVendas();
	}

	public Integer[] calculaCustoBasico(List<ProdutoDTO> itens) {
		int subtotal = 0;
		int imposto = 0;
		for (ProdutoDTO item : itens) {
			Produto produto = this.servicoDeProduto.buscaProduto(item.getCodigo());
			subtotal += produto.getPrecoUnitario() * item.getQuantidade();
		}
		imposto = this.calculoImpostoStrategy.calculaValorDoImposto(subtotal);
		final Integer[] resp = new Integer[3];
		resp[0] = subtotal;
		resp[1] = imposto;
		resp[2] = subtotal + imposto;
		return resp;
	}

	public boolean confirmaVenda(List<ProdutoDTO> itens) {
		List<ItemVenda> itensVenda = new ArrayList<>();
		Integer[] subtotais = this.calculaCustoBasico(itens);
		itens.forEach(item -> {
			Estoque estoque = this.servicoDeEstoque.buscaItemEstoque(item.getCodigo());
			estoque.setQuantidadeDisponivel(estoque.getQuantidadeDisponivel() - item.getQuantidade());
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setQuantidade(item.getQuantidade());
			itemVenda.setPrecoUnitVenda(subtotais[0]);
			itemVenda.setImposto(subtotais[1]);
			Produto produto = this.servicoDeProduto.buscaProduto(item.getCodigo());
			itemVenda.setProduto(produto);
			itensVenda.add(itemVenda);
		});
		Venda venda = new Venda();
		venda.setData(new Date());
		venda.setItensVenda(itensVenda);
		this.vendasRepository.salvar(venda);
		return true;
	}

	public boolean verificaDisponibilidade(Long codProd, Integer qtdade) {
		Estoque estoque = this.servicoDeEstoque.buscaItemEstoque(codProd);
		return estoque.getQuantidadeDisponivel() >= qtdade;
	}

}
