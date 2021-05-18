package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.sistemavendas.negocio.servicos.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class CalculaCustoBasicoUC {

	private ServicoVendas servicoVendas;

	@Autowired
	public CalculaCustoBasicoUC(ServicoVendas servicoVendas) {
		this.servicoVendas = servicoVendas;
	}

	public BigDecimal run() {
		return this.servicoVendas.calculaCustoBasico();
	}

}
