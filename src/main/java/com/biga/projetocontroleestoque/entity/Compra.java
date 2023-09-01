package com.biga.projetocontroleestoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "VALORDACOMPRA")
    private Double valorDaCompra;

    @Column(name = "VALORPRODUTO")
    private Double valorDoProduto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATADACOMPRA")
    private Date dataHoraCompra;

    private int quantidade;

}

