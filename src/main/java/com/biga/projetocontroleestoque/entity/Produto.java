package com.biga.projetocontroleestoque.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "TBPRODUTO")
public class Produto {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "NOME")
        private String nome;

        @Column(name = "VALOR")
        private Double valor;

        @Column(name = "QUANTIDADE")
        private Integer quantidade;

        public Produto() {}

        public Produto(String nome, Double valor, Integer quantidade) {
                this.nome = nome;
                this.valor = valor;
                this.quantidade = quantidade;
        }


        public Integer getId() {
                return id;
        }

        public String getNome() {
                return nome;
        }

        public Double getValor() {
                return valor;
        }

        public Integer getQuantidade() {
                return quantidade;
        }

        @Override
        public String toString() {
                return "Produto - ID: " + id + ", Nome: " + nome + ", Valor: " + valor + ", Quantidade: " + quantidade ;
        }
}
