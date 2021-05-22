package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.sistemavendas.aplicacao.dtos.ProdutoDTO;
import com.projearq.sistemavendas.negocio.entidades.ItemVenda;
import com.projearq.sistemavendas.negocio.servicos.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfirmaVendaUC {

    private ServicoVendas servicoVendas;

    @Autowired
    public ConfirmaVendaUC(ServicoVendas servicoVendas) {
        this.servicoVendas = servicoVendas;
    }

    public boolean run(List<ProdutoDTO> itens) throws Exception {
        return this.servicoVendas.confirmaVenda(itens);
    }

}
