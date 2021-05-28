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

    public static class Builder {
        private Long id = 0;
        private double quantidade = 0;
        private double precoUnitVenda = 0;
        private double imposto = 0;
        private Produto produto = new Produto(0,0,"-",0.0);
		private Date data = new Date();
		private List<ItemVenda> itensVenda = new List<ItemVenda>();
        private Venda venda = new Venda(0,0,data,itensVenda);

        public Builder() {}

        @Id
        @SequenceGenerator(allocationSize = 1, name = "id_itens_venda_seq", sequenceName = "id_itens_venda_seq")
        @GeneratedValue(generator = "id_itens_venda_seq", strategy = GenerationType.SEQUENCE)
        @Column(name = "id_itens_venda")
        public Builder getId() {return this.id;}

        public Builder setId(Long id) {this.id = id;}

        public Builder getQuantidade() {return this.quantidade;}

        public Builder setQuantidade(double quantidade) {this.quantidade = quantidade;}

        public Builder getPrecoUnitVenda() {return this.precoUnitVenda;}

        public Builder setPrecoUnitVenda(double precoUnitVenda) {this.precoUnitVenda = precoUnitVenda;}

        public Builder getImposto() {return this.imposto;}

        public Builder setImposto(double imposto) {this.imposto = imposto;}

        @OneToOne
        @JoinColumn(name = "id_produto", nullable = false)
        public Builder getProduto() {return this.produto;}

        public Builder setProduto(Produto produto) {this.produto = produto;}

        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "id_venda", nullable = false)
        public Builder getVenda() {return this.venda;}

        public Builder setVenda(Venda venda) {this.venda = venda;}

        public ItemVenda build() {return new ItemVenda(id, quantidade, precoUnitVenda, imposto, produto, venda);}
        //public ItemVenda build() {return new ItemVenda(this);}

        private ItemVenda(Builder builder) {
            this.id = builder.id;
            this.quantidade = builder.quantidade;
            this.precoUnitVenda = builder.precoUnitVenda;
            this.imposto = builder.imposto;
            this.produto = builder.produto;
            this.venda = builder.venda;
        }    
    }
}
