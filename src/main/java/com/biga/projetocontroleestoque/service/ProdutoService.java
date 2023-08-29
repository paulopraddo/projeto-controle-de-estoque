package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listeProdutos() {
        return produtoRepository.findAll();
    }

    public void criarNovoProduto(Produto produto) { produtoRepository.save(produto); }
}
