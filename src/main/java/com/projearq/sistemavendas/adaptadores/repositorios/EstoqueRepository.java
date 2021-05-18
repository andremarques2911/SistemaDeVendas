package com.projearq.sistemavendas.adaptadores.repositorios;

import com.projearq.sistemavendas.adaptadores.repositorios.interfaces.IEstoqueRepositoryCustom;
import com.projearq.sistemavendas.negocio.entidades.Estoque;
import com.projearq.sistemavendas.negocio.repositorios.IEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueRepository implements IEstoqueRepository {

	private IEstoqueRepositoryCustom estoqueRepositoryCustomu;

	@Autowired
	public EstoqueRepository(IEstoqueRepositoryCustom estoqueRepositoryCustomu) {
		this.estoqueRepositoryCustomu = estoqueRepositoryCustomu;
	}

	@Override
	public Estoque buscaItemEstoque(Long codigo) {
		return this.estoqueRepositoryCustomu.findByProduto_Codigo(codigo);
	}

}
