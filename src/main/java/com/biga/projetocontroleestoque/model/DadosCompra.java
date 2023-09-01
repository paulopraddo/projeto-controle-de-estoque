package com.biga.projetocontroleestoque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class DadosCompra {
    private Long clienteId;
    private Long produtoId;
    private Integer quantidade;
}
