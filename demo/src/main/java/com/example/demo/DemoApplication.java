package com.example.demo;

import com.example.demo.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha encoded: " + senhaEncoded);

			senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha encoded novamente: " + senhaEncoded);

			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));

			System.out.println("### Quantidade de elementos por página - " + this.qtdPorPagina);
		};
	}
}