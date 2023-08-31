package com.biga.projetocontroleestoque.controller;


import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import com.biga.projetocontroleestoque.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/estoque")
@RestController
public class EstoqueController {

    private final ProdutoService produtoService;

    @Autowired
    public EstoqueController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

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
    public ResponseEntity<String> consultarEstoque(@PathVariable Long idProduto) {
        return produtoService.procuraProdutoNoEstoque(idProduto);
    }

    @GetMapping("/excluirProduto/{idProduto}")
    public ResponseEntity<String> excluirProduto(@PathVariable Long idProduto) {
        return produtoService.excluiProduto(idProduto);
    }

    @Transactional
    @PostMapping("/realizarBaixaDeProduto/{produtoId}/baixa")
    public String realizarBaixaDeProduto(
            @PathVariable Integer produtoId,
            @RequestParam Integer quantidade) {
        return produtoService.realizarBaixaDeProduto(produtoId, quantidade);
    }

    @GetMapping("/verificaQuantidade/{idProduto}")
    public ResponseEntity<String> verificaQuantidadeProduto(@PathVariable Long idProduto) {
        return produtoService.verificarQuantidadeDeProduto(idProduto);
    }
}

