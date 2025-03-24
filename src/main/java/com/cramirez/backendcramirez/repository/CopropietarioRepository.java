package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Copropietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopropietarioRepository extends JpaRepository<Copropietario, Integer> {
}
