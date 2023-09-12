package com.biga.projetocontroleestoque.controller;

import com.biga.projetocontroleestoque.entity.Cliente;
import com.biga.projetocontroleestoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientesController {

    private ClienteService clienteService;

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping("/criarNovoCliente")
    public String criarNovoCliente(@RequestBody Cliente cliente) {
        clienteService.criarNovoCliente(cliente);
        return "Cliente criado com sucesso";
    }

    @GetMapping("/consultarCliente/{idCliente}")
    public ResponseEntity<String> consultarCliente(@PathVariable Integer idCliente) {
        return clienteService.consultarCliente(idCliente);
    }
}
