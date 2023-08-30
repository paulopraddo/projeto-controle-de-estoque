package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.entity.Cliente;
import com.biga.projetocontroleestoque.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) { this.clienteRepository = clienteRepository; }

    public List<Cliente> listarClientes() { return clienteRepository.findAll(); }

    public void criarNovoCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public ResponseEntity<String> consultarCliente(Integer id) {
        Cliente cliente = clienteRepository.findById(Long.valueOf(id)).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("ID: " + cliente.getId() +
                ", Nome: " + cliente.getNome() +
                ", Idade: " + cliente.getIdade());
    }

}
