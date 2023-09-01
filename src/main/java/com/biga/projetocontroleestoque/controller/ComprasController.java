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
        compraService.realizarCompra(dadosCompra);
        return "Compra realizada com sucesso";
    }

    @GetMapping("/exibirComprasCliente/{idCliente}")
    public String exibirComprasCliente(@PathVariable Long idCliente) {
        return compraService.exibirComprasCliente(idCliente);
    }
}
