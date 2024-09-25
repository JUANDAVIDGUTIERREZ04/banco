package com.sistemabancario.banco.Controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.sistemabancario.banco.Services.CuentaService;



@Controller
public class AdminCuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/admin/cuentas")
    public String listarCuentas(Model model) {
        model.addAttribute("cuentas", cuentaService.listarCuentas());
        return "administrador"; // nombre del archivo Thymeleaf
    }

   

    

}
