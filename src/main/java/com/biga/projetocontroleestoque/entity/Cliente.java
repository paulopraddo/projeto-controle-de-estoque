package com.biga.projetocontroleestoque.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBCLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "IDADE")
    private String idade;

    public Cliente() {}

    public Cliente(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }
}
