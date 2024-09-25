package com.sistemabancario.banco.Controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import com.sistemabancario.banco.Models.Cuenta;

import com.sistemabancario.banco.Services.CuentaService;
import com.sistemabancario.banco.Services.TransaccionService;

@Controller
public class SaldoController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired 
    private TransaccionService transaccionService;

    

    @GetMapping("/consultarUserSaldo")
    public String consultarUserSaldo(Model model) {
        // Obtener el nombre de usuario del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Buscar la cuenta asociada al usuario
        Cuenta cuenta = cuentaService.buscarCuentaPorUsuario(username);
        
        if (cuenta == null) {
            model.addAttribute("error", "No se encontró la cuenta asociada al usuario.");
            return "consultarUserSaldo"; // Asegúrate de manejar errores en la vista
        }

        model.addAttribute("saldo", cuenta.getSaldo());
        model.addAttribute("cuentaId", cuenta.getId()); // Asume que `getId()` devuelve el ID de la cuenta
        return "consultarUserSaldo"; // Nombre de la vista HTML
    }


    @GetMapping("/admin")
    public String saldoAdministrador(Model model) {
        // Obtener el nombre de usuario del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
    
        // Buscar la cuenta asociada al administrador
        Cuenta cuenta = cuentaService.buscarCuentaPorUsuario(username);
        
        if (cuenta == null) {
            model.addAttribute("error", "No se encontró la cuenta asociada al administrador.");
            return "administrador"; // Manejar errores en la vista
        }
    
        // Agregar el saldo de la cuenta al modelo
        model.addAttribute("saldo", cuenta.getSaldo());
       
    
        return "administrador"; // Nombre de la vista HTML
    }
    
    


}

