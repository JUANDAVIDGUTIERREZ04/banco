package com.sistemabancario.banco.Controllers;



import com.sistemabancario.banco.Models.Cuenta;
import com.sistemabancario.banco.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferenciaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/transferir")
    public String realizarTransferencia(
            @RequestParam Long cuentaId,
            @RequestParam Long cuentaDestinoId,
            @RequestParam Double monto,
            Model model) {
        
        Cuenta cuentaOrigen = cuentaService.encontrarPorId(cuentaId);
        Cuenta cuentaDestino = cuentaService.encontrarPorId(cuentaDestinoId);

        if (cuentaOrigen == null || cuentaDestino == null) {
            model.addAttribute("error", "Una de las cuentas no existe.");
            return "consultarUserSaldo"; // Redirige a la página de saldo
        }

        if (cuentaOrigen.getSaldo() < monto) {
            model.addAttribute("error", "Saldo insuficiente para la transferencia.");
            return "consultarUserSaldo"; // Redirige a la página de saldo
        }

        // Realiza la transferencia
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
        
        cuentaService.guardarCuenta(cuentaOrigen);
        cuentaService.guardarCuenta(cuentaDestino);

        model.addAttribute("saldo", cuentaOrigen.getSaldo());
        model.addAttribute("cuentaId", cuentaOrigen.getId());
        model.addAttribute("success", "Transferencia realizada con éxito.");
        
        return "consultarUserSaldo"; // Redirige a la página de saldo
    }
}
