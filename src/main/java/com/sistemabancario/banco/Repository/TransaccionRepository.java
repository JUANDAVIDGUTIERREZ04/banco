package com.sistemabancario.banco.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemabancario.banco.Models.Cuenta;
import com.sistemabancario.banco.Models.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByCuentaId(Long cuentaId);
    List<Transaccion> findByCuenta(Cuenta cuenta);
}


