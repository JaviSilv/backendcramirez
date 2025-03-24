package com.cramirez.backendcramirez.repository;
import com.cramirez.backendcramirez.entity.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer> {
}
