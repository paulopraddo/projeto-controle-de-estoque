package com.biga.projetocontroleestoque.controller;

import com.biga.projetocontroleestoque.service.CompraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class ComprasController {

    private final CompraService compraService;

    @PostMapping("/realizarCompra/clienteId/{clienteId}/produtoId/{produtoId}/quantidade/{quantidade}")
    public String realizarCompra(@PathVariable Long clienteId, @PathVariable Long produtoId, @PathVariable Integer quantidade) {
        compraService.realizarCompra(clienteId,produtoId,quantidade);
        return "Compra realizada com sucesso";
    }
}
