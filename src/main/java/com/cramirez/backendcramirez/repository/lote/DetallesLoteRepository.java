package com.cramirez.backendcramirez.repository.lote;

import com.cramirez.backendcramirez.entity.lote.DetallesLote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesLoteRepository extends JpaRepository<DetallesLote, Integer> {
}
