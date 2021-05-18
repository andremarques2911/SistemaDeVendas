package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

	private Long id;
	private int quantidadeDisponivel;
	private Produto produto;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "id_estoque_seq", sequenceName = "id_estoque_seq")
	@GeneratedValue(generator = "id_estoque_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_estoque")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	@OneToOne
	@JoinColumn(name = "id_produto", nullable = false)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
