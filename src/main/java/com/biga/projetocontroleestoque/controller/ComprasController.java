package com.biga.projetocontroleestoque.controller;

import com.biga.projetocontroleestoque.model.DadosCompra;
import com.biga.projetocontroleestoque.service.CompraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class ComprasController {

    private final CompraService compraService;

    @PostMapping("/realizarCompra")
    public String realizarCompra(@RequestBody DadosCompra dadosCompra) {
        Long clienteId = dadosCompra.getClienteId();
        Long produtoId = dadosCompra.getProdutoId();
        Integer quantidade = dadosCompra.getQuantidade();

        compraService.realizarCompra(clienteId, produtoId, quantidade);

        return "Compra realizada com sucesso";
    }
}
