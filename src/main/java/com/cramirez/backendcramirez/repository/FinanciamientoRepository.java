package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Financiamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanciamientoRepository extends JpaRepository<Financiamiento, Integer> {
}
