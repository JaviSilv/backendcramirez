package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Integer> {

    Optional<Lote> findTopByOrderByIdLoteDesc();
}
