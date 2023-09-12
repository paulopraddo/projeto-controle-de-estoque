package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Cliente;
import com.biga.projetocontroleestoque.entity.Compra;
import com.biga.projetocontroleestoque.entity.Produto;
import com.biga.projetocontroleestoque.model.DadosCompra;
import com.biga.projetocontroleestoque.repository.ClienteRepository;
import com.biga.projetocontroleestoque.repository.CompraRepository;
import com.biga.projetocontroleestoque.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Compra criarCompra(Cliente cliente, Produto produto, DadosCompra dadosCompra) {

        Double valorDoProduto = produto.getValor();
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProduto(produto);
        compra.setQuantidade(dadosCompra.getQuantidade());
        compra.setValorDaCompra(dadosCompra.getQuantidade() * valorDoProduto);
        compra.setValorDoProduto(valorDoProduto);
        compra.setDataHoraCompra(new Date());
        produto.setQuantidade(produto.getQuantidade() - dadosCompra.getQuantidade());
        produtoRepository.save(produto);

        return compra;
    }

    public void realizarCompra(DadosCompra dadosCompra) {
        Cliente cliente = clienteRepository.findById(dadosCompra.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dadosCompra.getProdutoId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        if (produto.getQuantidade() < dadosCompra.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        } else {
            Compra compra = criarCompra(cliente, produto, dadosCompra);
            compraRepository.save(compra);
        }
    }

    public String exibirComprasCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        List<Compra> comprasDoCliente = compraRepository.findByCliente(cliente);

        String retorno = null;
        if (comprasDoCliente.isEmpty()) {
            return ("O cliente não fez nenhuma compra.");
        } else {
            for (Compra compra : comprasDoCliente) {
                retorno = "ID da Compra: " + compra.getId() +
                "Data e Hora da Compra: " + compra.getDataHoraCompra() +
                "Produto: " + compra.getProduto().getNome() +
                "Quantidade: " + compra.getQuantidade() +
                "Valor da Compra: " + compra.getValorDaCompra();
            }
        }
        return retorno;
    }
}

