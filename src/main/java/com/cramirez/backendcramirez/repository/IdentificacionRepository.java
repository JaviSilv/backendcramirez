package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Identificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificacionRepository extends JpaRepository<Identificacion, Integer> {
}
