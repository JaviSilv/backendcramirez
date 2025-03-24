package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.Prefijotelefonico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefijotelefonicoRepository extends JpaRepository<Prefijotelefonico, Integer> {
}
