package com.biga.projetocontroleestoque.repository;

import com.biga.projetocontroleestoque.entity.Cliente;
import com.biga.projetocontroleestoque.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByCliente(Cliente cliente);
}
