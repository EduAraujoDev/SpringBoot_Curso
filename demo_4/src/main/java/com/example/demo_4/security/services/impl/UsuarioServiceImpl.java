package com.example.demo_4.security.services.impl;

import com.example.demo_4.security.entities.Usuario;
import com.example.demo_4.security.repositories.UsuarioRepository;
import com.example.demo_4.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
    }
}