package com.example.demo_5;

import com.example.demo_5.services.ExemploCacheServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Demo5Application {

	@Autowired
	private ExemploCacheServices exemploCacheServices;

	public static void main(String[] args) {
		SpringApplication.run(Demo5Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Executando serviço pela primeira vez!");
			System.out.println(this.exemploCacheServices.exemploCache());

			System.out.println("Executando serviço pela segunda vez, deve obter dados do cache.");
			System.out.println(this.exemploCacheServices.exemploCache());
		};
	}
}