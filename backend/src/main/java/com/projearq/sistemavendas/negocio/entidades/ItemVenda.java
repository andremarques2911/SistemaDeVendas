package com.projearq.sistemavendas.negocio.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "itens_venda")
public class ItemVenda {

	private Long id;
	private double quantidade;
	private double precoUnitVenda;
	private double imposto;
	private Produto produto;
	private Venda venda;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "id_itens_venda_seq", sequenceName = "id_itens_venda_seq")
	@GeneratedValue(generator = "id_itens_venda_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_itens_venda")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoUnitVenda() {
		return precoUnitVenda;
	}

	public void setPrecoUnitVenda(double precoUnitVenda) {
		this.precoUnitVenda = precoUnitVenda;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	@OneToOne
	@JoinColumn(name = "id_produto", nullable = false)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_venda", nullable = false)
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
