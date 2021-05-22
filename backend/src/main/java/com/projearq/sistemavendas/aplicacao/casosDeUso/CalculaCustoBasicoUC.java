package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.sistemavendas.aplicacao.dtos.ProdutoDTO;
import com.projearq.sistemavendas.negocio.entidades.ItemVenda;
import com.projearq.sistemavendas.negocio.servicos.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculaCustoBasicoUC {

	private ServicoVendas servicoVendas;

	@Autowired
	public CalculaCustoBasicoUC(ServicoVendas servicoVendas) {
		this.servicoVendas = servicoVendas;
	}

	public Integer[] run(List<ProdutoDTO> itens) throws Exception {
		return this.servicoVendas.calculaCustoBasico(itens);
	}

}
