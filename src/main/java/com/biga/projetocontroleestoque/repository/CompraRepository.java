package com.biga.projetocontroleestoque.repository;

import com.biga.projetocontroleestoque.entity.Compra;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO COMPRA ( ID, CLIENTE_ID, PRODUTO_ID, QUANTIDADE) VALUES (:id , :cliente_id, :produto_id, :quantidade);", nativeQuery = true)
//    void realizarCompra(@Param("id") Integer id, @Param("cliente_id") Integer cliente_id, @Param("produto_id") Integer produto_id, @Param("quantidade") Integer quantidade);
}
