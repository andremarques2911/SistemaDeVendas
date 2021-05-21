package com.projearq.sistemavendas.negocio.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {

	private Long id;
	private long numero;
	private Date data;
	private List<ItemVenda> itensVenda;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "id_venda_seq", sequenceName = "id_venda_seq")
	@GeneratedValue(generator = "id_venda_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_venda_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "venda")
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

}
