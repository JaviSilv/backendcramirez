package com.cramirez.backendcramirez.repository;


import com.cramirez.backendcramirez.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findById(Integer id);

    Optional<Cliente> findTopByOrderByIdClienteDesc();

    List<Cliente> findByIdOperario(int idOperario);


}
