package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

	private Long id;
	private Long codigo;
	private String descricao;
	private double precoUnitario;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "id_produto_seq", sequenceName = "id_produto_seq")
	@GeneratedValue(generator = "id_produto_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_produto")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

}
