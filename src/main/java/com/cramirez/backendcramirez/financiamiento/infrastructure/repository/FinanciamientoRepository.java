package com.cramirez.backendcramirez.financiamiento.infrastructure.repository;

import com.cramirez.backendcramirez.entity.financiamiento.Financiamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanciamientoRepository extends JpaRepository<Financiamiento, Integer> {
}
