package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto encontraProduto(Long idProduto) {return produtoRepository.findById(idProduto).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));}

    public List<Produto> listeProdutos() {
        return produtoRepository.findAll();
    }

    public void criarNovoProduto(Produto produto) { produtoRepository.save(produto); }

    public String exibeProdutoDoEstoque(Long id) {
        Produto produto = encontraProduto(id);
        return "ID: " + produto.getId() +
                ", Nome: " + produto.getNome() +
                ", Valor: " + produto.getValor() +
                ", Quantidade: " + produto.getQuantidade();
    }
    public void excluiProduto(Long id) {
        Produto produto = encontraProduto(id);
        produtoRepository.deleteById(id);

    }


    public void atualizarQuantidade(Long produtoId, Integer quantidade) {
        Produto produto = encontraProduto(produtoId);
        produtoRepository.atualizarQuantidade(produtoId,quantidade);
    }


    public String verificarQuantidadeDeProduto(Long produtoId) {
        Produto produto = encontraProduto(produtoId);
        return produto.getNome() + ": " + produto.getQuantidade();
    }

    public void baixaDeProduto(Long idProduto, Integer quantidade) {
        Produto encontraProduto = encontraProduto(idProduto);
        Produto produto = verificaSeQuantidadeEMenor(idProduto,quantidade);
        Integer novaQuantidade = produto.getQuantidade() - quantidade;
        produtoRepository.baixaDeProduto(idProduto, novaQuantidade);
    }

    public Produto verificaSeQuantidadeEMenor(Long produtoId, Integer quantidade) {
        Produto produto = encontraProduto(produtoId);
        if (produto.getQuantidade() >= quantidade) {
            return produto;
        }

        throw new RuntimeException("Erro: Quantidade insuficiente em estoque para o produto com ID " + produtoId);
    }
}
