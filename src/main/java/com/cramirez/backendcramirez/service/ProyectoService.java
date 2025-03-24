package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.ProyectoDTO;
import com.cramirez.backendcramirez.entity.Proyecto;
import com.cramirez.backendcramirez.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<ProyectoDTO> findAll() {
        return proyectoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProyectoDTO> findById(int id) {
        return proyectoRepository.findById(id).map(this::convertToDTO);
    }

    public ProyectoDTO save(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = convertToEntity(proyectoDTO);
        Proyecto savedProyecto = proyectoRepository.save(proyecto);
        return convertToDTO(savedProyecto);
    }

    public void deleteById(int id) {
        proyectoRepository.deleteById(id);
    }

    private ProyectoDTO convertToDTO(Proyecto proyecto) {
        return new ProyectoDTO(
                proyecto.getIdProyecto(),
                proyecto.getIdEmpresa(),
                proyecto.getNombreProyecto()
        );
    }

    private Proyecto convertToEntity(ProyectoDTO dto) {
        return new Proyecto(
                dto.getIdProyecto(),
                dto.getIdEmpresa(),
                dto.getNombreProyecto()
        );
    }
}
