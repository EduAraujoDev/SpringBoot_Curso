package com.example.demo_4;

import com.example.demo_4.security.entities.Usuario;
import com.example.demo_4.security.enums.PerfilEnum;
import com.example.demo_4.security.repositories.UsuarioRepository;
import com.example.demo_4.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo4Application {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);

			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
		};
	}
}