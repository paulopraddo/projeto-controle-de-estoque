package com.biga.projetocontroleestoque.controller;

import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/insert")
    public String testInsert() {
        // Criar um objeto Produto com valores fixos
        Produto produto = new Produto("Produto de Teste", 9.99, 10);

        // Salvar o produto no banco de dados usando o repositório
        produtoRepository.save(produto);

        return "Produto inserido com sucesso!";
    }
}
