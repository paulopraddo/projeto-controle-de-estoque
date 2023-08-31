package com.biga.projetocontroleestoque.service;

import com.biga.projetocontroleestoque.repository.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;


}
