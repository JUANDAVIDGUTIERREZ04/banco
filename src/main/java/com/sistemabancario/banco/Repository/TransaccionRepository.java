package com.sistemabancario.banco.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemabancario.banco.Models.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}

