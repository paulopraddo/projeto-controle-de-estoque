package com.biga.projetocontroleestoque.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "TBPRODUTO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
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

}
