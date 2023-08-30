package com.biga.projetocontroleestoque.controller;


import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import com.biga.projetocontroleestoque.service.ProdutoService;
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

    @Autowired
    private ProdutoRepository produtoRepository;

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
    public ResponseEntity<String> consultarEstoque(@PathVariable Integer idProduto) {
        return produtoService.procuraProdutoNoEstoque(idProduto);
    }
}

