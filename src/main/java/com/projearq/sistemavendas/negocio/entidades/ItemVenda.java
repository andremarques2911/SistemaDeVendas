package com.projearq.sistemavendas.negocio.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "itens_venda")
public class ItemVenda {

	private Long id;
	private int quantidade;
	private int precoUnitVenda;
	private long imposto;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getPrecoUnitVenda() {
		return precoUnitVenda;
	}

	public void setPrecoUnitVenda(int precoUnitVenda) {
		this.precoUnitVenda = precoUnitVenda;
	}

	public long getImposto() {
		return imposto;
	}

	public void setImposto(long imposto) {
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
