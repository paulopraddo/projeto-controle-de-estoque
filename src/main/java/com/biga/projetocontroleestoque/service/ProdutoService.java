package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> procuraProdutoNoEstoque(Integer id) {
        Produto produto = produtoRepository.findById(Long.valueOf(id)).orElse(null);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("ID: " + produto.getId() +
                ", Nome: " + produto.getNome() +
                ", Valor: " + produto.getValor() +
                ", Quantidade: " + produto.getQuantidade());
    }
}
