package com.biga.projetocontroleestoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProjetoControleEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoControleEstoqueApplication.class, args);
	}

}
