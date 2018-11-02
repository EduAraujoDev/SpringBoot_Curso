package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DemoApplicationTests {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCarregaContextoDeTeste() {
		Assert.assertEquals(100, qtdPorPagina);
	}
}