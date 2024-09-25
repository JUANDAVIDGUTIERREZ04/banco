package com.sistemabancario.banco.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemabancario.banco.Models.Cuenta;



 @Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    
    Cuenta findByUsuarioUsername(String username);
}


