package com.sistemabancario.banco.Services;


import com.sistemabancario.banco.Models.Cuenta;
import com.sistemabancario.banco.Models.Transaccion;

import com.sistemabancario.banco.Repository.TransaccionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;
    

    public void registrarTransaccion(Transaccion transaccion) {
        transaccionRepository.save(transaccion);
    }

    public List<Transaccion> obtenerTransaccionesPorCuenta(Long cuentaId) {
        return transaccionRepository.findByCuentaId(cuentaId);
    }

     
    
    public List<Transaccion> obtenerTransaccionesPorCuenta(Cuenta cuenta) {
        return transaccionRepository.findByCuenta(cuenta);
    }
}
