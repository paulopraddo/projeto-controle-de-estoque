package com.biga.projetocontroleestoque.controller;


import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.service.CompraService;
import com.biga.projetocontroleestoque.service.ProdutoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/estoque")
@RestController
@AllArgsConstructor
public class EstoqueController {

    private final ProdutoService produtoService;

    @GetMapping
    public String paginaInicial() {
        return """
                \n Projeto Controle de Estoque
                \n 1 - Listar Produtos: /estoque/listarProdutos
                \n 2 - Consultar Estoque: /estoque/consultarEstoque{idproduto}
                \n 3 - Inserir Produto: /estoque/inserirProduto/id,nome,valor,quantidade
                """;
    }

    @GetMapping("/listarProdutos")
    public List<Produto> listarProdutos() {
        return produtoService.listeProdutos();
    }

    @PostMapping("/inserirProdutos")
    public ResponseEntity<String> createProduct(@RequestBody Produto produto) {
        produtoService.criarNovoProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado com sucesso");
    }

    @GetMapping("/consultarEstoque/{idProduto}")
    public String consultarEstoque(@PathVariable Long idProduto) {
        return produtoService.exibeProdutoDoEstoque(idProduto);
    }

    @GetMapping("/excluirProduto/{idProduto}")
    public String excluirProduto(@PathVariable Long idProduto) {
        produtoService.excluiProduto(idProduto);
        return "Produto deletado com sucesso";
    }

    @Transactional
    @PostMapping("/atualizarQuantidade/id/{produtoId}/quantidade/{quantidade}")
    public String atualizarQuantidadeProduto(@PathVariable Long produtoId, @PathVariable Integer quantidade) {
        produtoService.atualizarQuantidade(produtoId,quantidade);
        return "Valor atualizado com sucesso";
    }

    @GetMapping("/verificaQuantidade/{idProduto}")
    public String verificaQuantidadeProduto(@PathVariable Long idProduto) {
        return produtoService.verificarQuantidadeDeProduto(idProduto);
    }

    @PostMapping("/realizarBaixaDeProduto/id/{produtoId}/quantidade/{quantidade}")
    public String realizarBaixaDeProduto(
            @PathVariable Long produtoId,
            @PathVariable Integer quantidade) {
        produtoService.baixaDeProduto(produtoId,quantidade);
        return "Baixa realizada com sucesso";
    }

}

