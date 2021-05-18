package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.sistemavendas.negocio.servicos.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;

public class EfetuarVendaUC {

	private ServicoVendas servicoVendas;

	@Autowired
	public EfetuarVendaUC(ServicoVendas servicoVendas) {
		this.servicoVendas = servicoVendas;
	}

	public boolean run() {
		return this.servicoVendas.efetuarVenda();
	}

}
