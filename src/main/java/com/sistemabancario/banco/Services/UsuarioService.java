package com.sistemabancario.banco.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemabancario.banco.Models.Usuario;
import com.sistemabancario.banco.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
