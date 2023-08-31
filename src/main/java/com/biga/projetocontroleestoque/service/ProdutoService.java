package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public ResponseEntity<String> procuraProdutoNoEstoque(Long id) {
        Produto produto = produtoRepository.findById(Long.valueOf(id)).orElse(null);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("ID: " + produto.getId() +
                ", Nome: " + produto.getNome() +
                ", Valor: " + produto.getValor() +
                ", Quantidade: " + produto.getQuantidade());
    }
    public ResponseEntity<String> excluiProduto(Long id) {
        Produto produto = produtoRepository.findById(Long.valueOf(id)).orElse(null);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);

        return ResponseEntity.ok("Produto deletado com sucesso");
    }

    @Transactional
    public String realizarBaixaDeProduto(Integer produtoId, Integer quantidade) {
        Produto produto = produtoRepository.findById(Long.valueOf(produtoId)).orElse(null);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            produtoRepository.atualizarQuantidade(produtoId,quantidade);
            return "Baixa do produto realizada com sucesso." +
                    "ID: " + produto.getId() +
                    ", Nome: " + produto.getNome() +
                    ", Valor: " + produto.getValor() +
                    ", Quantidade: " + produto.getQuantidade();
        } else {
            throw new IllegalArgumentException("Produto não encontrado ou quantidade insuficiente.");
        }
    }

    public ResponseEntity<String> verificarQuantidadeDeProduto(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId).orElse(null);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto.getNome() + ": " + produto.getQuantidade());
    }


}
