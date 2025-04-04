package com.cramirez.backendcramirez.repository.localizacion;


import com.cramirez.backendcramirez.entity.localizacion.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}
