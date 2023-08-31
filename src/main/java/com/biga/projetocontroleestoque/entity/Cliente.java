package com.biga.projetocontroleestoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBCLIENTES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "IDADE")
    private String idade;

    @Column(name = "COMPRASREALIZADAS")
    private Integer comprasRealizadas;

}
