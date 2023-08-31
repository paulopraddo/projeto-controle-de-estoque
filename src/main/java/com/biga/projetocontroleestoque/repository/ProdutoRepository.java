package com.biga.projetocontroleestoque.repository;

import com.biga.projetocontroleestoque.entity.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBPRODUTO SET quantidade = :quantidade WHERE id = :id", nativeQuery = true)
    void atualizarQuantidade(@Param("id") Integer id, @Param("quantidade") Integer quantidade);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBPRODUTO SET NOME = :nome WHERE id = :id", nativeQuery = true)
    void atualizarNome(@Param("id") Integer id, @Param("nome") String nome);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBPRODUTO SET VALOR = :valor WHERE id = :id", nativeQuery = true)
    void atualizarValor(@Param("id") Integer id, @Param("valor") Double valor);

}

