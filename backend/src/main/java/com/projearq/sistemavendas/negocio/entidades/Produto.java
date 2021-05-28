package com.projearq.sistemavendas.negocio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    private Long id;
	private Long codigo;
	private String descricao;
	private double precoUnitario;
    
    public static class Builder {

        private Long id = 0;
        private Long codigo = 0;
        private String descricao = "-";
        private double precoUnitario = 0;

        public Builder() {}

        @Id
        @SequenceGenerator(allocationSize = 1, name = "id_produto_seq", sequenceName = "id_produto_seq")
        @GeneratedValue(generator = "id_produto_seq", strategy = GenerationType.SEQUENCE)
        @Column(name = "id_produto")
        public Builder getId() {return this.id;}

        public Builder setId(Long id) {this.id = id;}

        public Builder getCodigo() {return this.codigo;}

        public Builder setCodigo(Long codigo) {this.codigo = codigo;}

        public Builder getDescricao() {return this.descricao;}

        public Builder setDescricao(String descricao) {this.descricao = descricao;}

        public Builder getPrecoUnitario() {return this.precoUnitario;}

        public Builder setPrecoUnitario(double precoUnitario) {this.precoUnitario = precoUnitario;}

        public Produto build() {return new Produto(id, Codigo, Descricao, PrecoUnitario);}
        //public Produto build() {return new Produto(this);}

        private Produto(Builder builder) {
            this.id = builder.id;
            this.codigo = builder.codigo;
            this.descricao = builder.descricao;
            this.precoUnitario = builder.precoUnitario;
        }
    }
}
