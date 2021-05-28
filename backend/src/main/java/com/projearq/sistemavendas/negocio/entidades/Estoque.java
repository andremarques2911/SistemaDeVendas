package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "id_estoque_seq", sequenceName = "id_estoque_seq")
    @GeneratedValue(generator = "id_estoque_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_estoque")
	private Long id;
	private int quantidadeDisponivel;
    @OneToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;

    public static class Builder {
        private Long id = null;
        private int quantidadeDisponivel = 0;
        private Produto produto = null;

        public Builder() {}
		
        public Builder quantidadeDisponivel(int quantidadeDisponivel) {this.quantidadeDisponivel = quantidadeDisponivel; return this;}

        public Builder produto(Produto produto) {this.produto = produto; return this;}

        public Estoque build() {return new EstoqueB(this);}

    }

    private Estoque(Builder builder) {
        this.id = builder.id;
        this.quantidadeDisponivel = builder.quantidadeDisponivel;
        this.produto = builder.produto;
    }

    public int getQuantidadeDisponivel() {return this.quantidadeDisponivel;}

    public Produto getProduto() {return this.produto;}

    public Long getId() {return this.id;}
}
