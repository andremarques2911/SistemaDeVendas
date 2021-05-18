package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.sistemavendas.negocio.entidades.Produto;
import com.projearq.sistemavendas.negocio.servicos.ServicoDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaProdutosUC {

	private ServicoDeProduto servicoDeProduto;

	@Autowired
	public ConsultaProdutosUC(ServicoDeProduto servicoDeProduto) {
		this.servicoDeProduto = servicoDeProduto;
	}

	public List<Produto> run() {
		return this.servicoDeProduto.consultaProduto();
	}

}
