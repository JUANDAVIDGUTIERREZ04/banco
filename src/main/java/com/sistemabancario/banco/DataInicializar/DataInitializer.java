package com.sistemabancario.banco.DataInicializar;
/*
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sistemabancario.banco.Models.Cuenta;
import com.sistemabancario.banco.Models.Transaccion;
import com.sistemabancario.banco.Models.Usuario;
import com.sistemabancario.banco.Services.CuentaService;
import com.sistemabancario.banco.Services.TransaccionService;
import com.sistemabancario.banco.Services.UsuarioService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioService usuarioService;
    private final CuentaService cuentaService;
    private final TransaccionService transaccionService;

    public DataInitializer(UsuarioService usuarioService, CuentaService cuentaService, TransaccionService transaccionService) {
        this.usuarioService = usuarioService;
        this.cuentaService = cuentaService;
        this.transaccionService = transaccionService;
    }

    @Override
public void run(String... args) throws Exception {
    // Crear usuarios
    Usuario usuario1 = new Usuario();
    usuario1.setUsername("ana");
    usuario1.setPassword("{noop}111"); // Asignar la contraseña en texto plano
    usuario1.setRole("USER");
    usuarioService.guardarUsuario(usuario1);

    Usuario usuario2 = new Usuario();
    usuario2.setUsername("olivia");
    usuario2.setPassword("{noop}111");
    usuario2.setRole("USER");
    usuarioService.guardarUsuario(usuario2);

    // Crear cuentas
    Cuenta cuenta1 = new Cuenta();
    cuenta1.setUsuario(usuario1);
    cuenta1.setSaldo(10000.0);
    cuentaService.guardarCuenta(cuenta1);

    Cuenta cuenta2 = new Cuenta();
    cuenta2.setUsuario(usuario2);
    cuenta2.setSaldo(20000.0);
    cuentaService.guardarCuenta(cuenta2);

    // Crear transacciones
    Transaccion transaccion1 = new Transaccion();
    transaccion1.setCuenta(cuenta1);
    transaccion1.setMonto(10000.0);
    transaccion1.setTipo("DEPOSITO");
    transaccionService.guardarTransaccion(transaccion1);

    Transaccion transaccion2 = new Transaccion();
    transaccion2.setCuenta(cuenta2);
    transaccion2.setMonto(50.0);
    transaccion2.setTipo("RETIRADA");
    transaccionService.guardarTransaccion(transaccion2);
}
}
*/