package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.OcupacionDTO;
import com.cramirez.backendcramirez.entity.Ocupacion;
import com.cramirez.backendcramirez.repository.OcupacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OcupacionService {

    @Autowired
    private OcupacionRepository ocupacionRepository;

    public List<OcupacionDTO> listarOcupaciones() {
        List<Ocupacion> ocupaciones = ocupacionRepository.findAll();
        return ocupaciones.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    private OcupacionDTO convertirADTO(Ocupacion ocupacion) {
        OcupacionDTO dto = new OcupacionDTO();
        dto.setIdOcupacion(ocupacion.getIdOcupacion());
        dto.setNombreOcupacion(ocupacion.getNombreOcupacion());
        return dto;
    }
}