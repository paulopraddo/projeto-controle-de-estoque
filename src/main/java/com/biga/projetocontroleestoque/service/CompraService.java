package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Cliente;
import com.biga.projetocontroleestoque.entity.Compra;
import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.repository.ClienteRepository;
import com.biga.projetocontroleestoque.repository.CompraRepository;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void realizarCompra(Long clienteId, Long produtoId, Integer quantidade) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        if (produto.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        Double valorDoProduto = produto.getValor();

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProduto(produto);
        compra.setQuantidade(quantidade);
        compra.setValorDaCompra(quantidade * valorDoProduto);
        compra.setValorDoProduto(valorDoProduto);

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);

        compraRepository.save(compra);
    }
}

