package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.DetallesLote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesLoteRepository extends JpaRepository<DetallesLote, Integer> {
}
