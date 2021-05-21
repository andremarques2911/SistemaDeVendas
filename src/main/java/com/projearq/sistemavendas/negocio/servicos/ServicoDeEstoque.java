package com.projearq.sistemavendas.negocio.servicos;

import com.projearq.sistemavendas.negocio.entidades.Estoque;
import com.projearq.sistemavendas.negocio.repositorios.IEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDeEstoque {

    private IEstoqueRepository estoqueRepository;

    @Autowired
    public ServicoDeEstoque(IEstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public Estoque adiconaEstoqueProduto(Estoque estoque) {
       return this.estoqueRepository.adicionaEstoqueProduto(estoque);
    }

    public Estoque buscaItemEstoque(Long codigo) {
        return this.estoqueRepository.buscaItemEstoque(codigo);
    }
}
