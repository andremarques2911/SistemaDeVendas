package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

	private Long id;
	private int quantidadeDisponivel;
	private Produto produto;

    public static class Builder {
        private Long id = 0;
        private int quantidadeDisponivel = 0;
        private Produto produto = new Produto(0,0,"-",0.0);

        public Builder() {}
		
        @Id
    	@SequenceGenerator(allocationSize = 1, name = "id_estoque_seq", sequenceName = "id_estoque_seq")
	    @GeneratedValue(generator = "id_estoque_seq", strategy = GenerationType.SEQUENCE)
	    @Column(name = "id_estoque")
        public Builder getId() {return this.id;}

        public Builder setId(Long id) {this.id = id;}
        
        public Builder getQuantidadeDisponivel() {return this.quantidadeDisponivel}

        public Builder setQuantidadeDisponivel(int quantidadeDisponivel) {this.quantidadeDisponivel = quantidadeDisponivel;}

        @OneToOne
	    @JoinColumn(name = "id_produto", nullable = false)
        public Builder getProduto() {return this.produto}

        public Builder setProduto(Produto produtor) {this.produto = produto;}

        public Estoque build() {return new Estoque(id, quantidadeDisponivel, produto);}
        //public Estoque build() {return new EstoqueB(this);}

        private Estoque(Builder builder) {
            this.id = builder.id;
            this.quantidadeDisponivel = builder.quantidadeDisponivel;
            this.produto = builder.produto;
        }
    }

}
