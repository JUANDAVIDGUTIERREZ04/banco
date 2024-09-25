package com.sistemabancario.banco.Services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemabancario.banco.Models.Cuenta;

import com.sistemabancario.banco.Models.Usuario;
import com.sistemabancario.banco.Repository.CuentaRepository;
import com.sistemabancario.banco.Repository.TransaccionRepository;
import com.sistemabancario.banco.Repository.UsuarioRepository;

import java.util.List;


@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;
     
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Cuenta> listarCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta buscarCuentaPorId(Long id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public void guardarCuenta(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    

    public Cuenta encontrarPorId(Long id) {
        return cuentaRepository.findById(id)
                .orElse(null); // Retorna null si no se encuentra
    }

    public Usuario encontrarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Cuenta buscarCuentaPorUsuario(String username) {
        return cuentaRepository.findByUsuarioUsername(username);
    
    
}


}