package com.example.demo;

import com.example.demo.entities.Empresa;
import com.example.demo.repositories.EmpresaRepository;
import com.example.demo.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private EmpresaRepository empresaRepository;

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

			// Teste de persistencia
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Teste IT");
			empresa.setCnpj("74645215000104");

			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);

			Empresa empresaDb = empresaRepository.findById(1L).orElse(null);
			System.out.println("Empresa por ID: " + empresaDb);

			empresaDb.setRazaoSocial("Teste IT Web");
			this.empresaRepository.save(empresaDb);

			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);

			this.empresaRepository.deleteById(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
		};
	}
}