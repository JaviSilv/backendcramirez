package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Operario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperarioRepository extends JpaRepository<Operario, Integer> {
}
