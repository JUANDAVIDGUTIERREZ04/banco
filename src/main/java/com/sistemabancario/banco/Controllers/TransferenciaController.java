package com.sistemabancario.banco.Controllers;

import com.sistemabancario.banco.Models.Cuenta;
import com.sistemabancario.banco.Models.Transaccion;
import com.sistemabancario.banco.Services.CuentaService;
import com.sistemabancario.banco.Services.TransaccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TransferenciaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private TransaccionService transaccionService;

    // Método para manejar la consulta de saldo
    @GetMapping("consultarSaldoTransferencia")
    public String consultarSaldo(@RequestParam Long cuentaId, Model model) {
        Cuenta cuenta = cuentaService.encontrarPorId(cuentaId);
        if (cuenta != null) {
            model.addAttribute("saldo", cuenta.getSaldo());
            model.addAttribute("cuentaId", cuentaId);
            // Obtener las transacciones para mostrarlas en la vista
            List<Transaccion> transacciones = transaccionService.obtenerTransaccionesPorCuenta(cuentaId);
            model.addAttribute("transacciones", transacciones);
        }
        return "consultarUserSaldo"; // Nombre de tu vista
    }

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
            return "redirect:/consultarSaldoTransferencia?cuentaId=" + cuentaId; // Redirige correctamente
        }

        if (cuentaOrigen.getSaldo() < monto) {
            model.addAttribute("error", "Saldo insuficiente para la transferencia.");
            return "redirect:/consultarSaldoTransferencia?cuentaId=" + cuentaId; // Redirige correctamente
        }

        // Realiza la transferencia
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
        
        cuentaService.guardarCuenta(cuentaOrigen);
        cuentaService.guardarCuenta(cuentaDestino);

        // Registrar la transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setTipo("Transferencia");
        transaccion.setMonto(monto);
        transaccion.setCuenta(cuentaOrigen); // Cambia a cuentaDestino si prefieres
        transaccionService.registrarTransaccion(transaccion);

        // Redirigir a la consulta de saldo
        return "redirect:/consultarSaldoTransferencia?cuentaId=" + cuentaId; // Asegúrate de que la URL sea correcta
    }
}
