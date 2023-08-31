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
    @Query(value = "UPDATE tbproduto SET quantidade = :quantidade WHERE id = :id", nativeQuery = true)
    void atualizarQuantidade(@Param("quantidade") Integer quantidade, @Param("id") Integer id);
}

