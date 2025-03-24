package com.cramirez.backendcramirez.repository;

import com.cramirez.backendcramirez.entity.CopropietarioConyuge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopropietarioConyugeRepository extends JpaRepository<CopropietarioConyuge, Integer> {
}
