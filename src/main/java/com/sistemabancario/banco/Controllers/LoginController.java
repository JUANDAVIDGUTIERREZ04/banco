package com.sistemabancario.banco.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistemabancario.banco.Models.Usuario;
import com.sistemabancario.banco.Services.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Vista del formulario de inicio de sesión
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        String username = authentication.getName();
        Usuario usuario = usuarioService.buscarPorUsername(username);

        // Verificar roles y redirigir a la página adecuada
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "redirect:/admin/cuentas"; // Redirigir al administrador
        } else if (usuario != null) {
            return "redirect:/consultarUserSaldo"; // Redirigir al usuario regular
        }
        return "redirect:/"; // Redirigir a la página principal si no se encuentra el usuario
    }
}
