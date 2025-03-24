package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Credenciales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {
    Optional<Credenciales> findByUsuario(String usuario);



}
