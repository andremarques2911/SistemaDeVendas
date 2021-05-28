package com.projearq.sistemavendas.negocio.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {

    private Long id;
	private Long numero;
	private Date data;
	private List<ItemVenda> itensVenda;

    public static class Builder {

        private Long id = 0;
        private Long numero = 0;
        private Date data = new Date();
        private List<ItemVenda> itensVenda = new List<ItemVenda>();

        public Builder() {}

        @Id
        @SequenceGenerator(allocationSize = 1, name = "id_venda_seq", sequenceName = "id_venda_seq")
        @GeneratedValue(generator = "id_venda_seq", strategy = GenerationType.SEQUENCE)
        @Column(name = "id_venda_seq")
        public Builder getId() {return this.id;}

        public Builder setId(Long id) {this.id = id;}

        public Builder getNumero() {return this.numero;}

        public Builder setNumero(Long numero) {this.numero = numero;}

        public Builder getData() {return this.data;}

        public Builder setData(Date data) {this.data = data;}

        @JsonManagedReference
        @OneToMany(mappedBy = "venda")
        public Builder getItensVenda() {return this.itensVenda;}

        public Builder setItensVenda(List<ItemVenda> itensVenda) {this.itensVenda = itensVenda;}

        public Venda build() {return new Venda(id, numero, data, itensVenda);}
        //public Venda build() {return new Venda(this);}

        private Venda(Builder builder) {
            this.id = builder.id;
            this.numero = builder.numero;
            this.data = builder.data;
            this.itensVenda = builder.itensVenda;
        }
    }
}
