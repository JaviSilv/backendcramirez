package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.EmpresaDTO;
import com.cramirez.backendcramirez.entity.Empresa;
import com.cramirez.backendcramirez.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaDTO> obtenerTodasLasEmpresas() {
        return empresaRepository.findAll().stream()
                .map(this::convertirA_DTO)
                .collect(Collectors.toList());
    }

    public EmpresaDTO obtenerEmpresaPorId(int id) {
        return empresaRepository.findById(id)
                .map(this::convertirA_DTO)
                .orElse(null);
    }

    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = convertirA_Entidad(empresaDTO);
        Empresa empresaGuardada = empresaRepository.save(empresa);
        return convertirA_DTO(empresaGuardada);
    }

    public EmpresaDTO actualizarEmpresa(int id, EmpresaDTO empresaDTO) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.setIdEmpresa(empresaDTO.getIdEmpresa());
                    empresa.setIdUbicacionINEI(empresaDTO.getIdUbicacionINEI());
                    empresa.setNombreEmpresa(empresaDTO.getNombreEmpresa());
                    empresa.setRuc(empresaDTO.getRuc());
                    empresa.setDireccion(empresaDTO.getDireccion());
                    empresa.setRepresentanteLegal(empresaDTO.getRepresentanteLegal());
                    empresa.setNPartidaEmpresa(empresaDTO.getNPartidaEmpresa());
                    Empresa empresaActualizada = empresaRepository.save(empresa);
                    return convertirA_DTO(empresaActualizada);
                })
                .orElse(null);
    }

    public void eliminarEmpresa(int id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDTO convertirA_DTO(Empresa empresa) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setIdEmpresa(empresa.getIdEmpresa());
        dto.setIdUbicacionINEI(empresa.getIdUbicacionINEI());
        dto.setNombreEmpresa(empresa.getNombreEmpresa());
        dto.setRuc(empresa.getRuc());
        dto.setDireccion(empresa.getDireccion());
        dto.setRepresentanteLegal(empresa.getRepresentanteLegal());
        dto.setNPartidaEmpresa(empresa.getNPartidaEmpresa());
        return dto;
    }

    private Empresa convertirA_Entidad(EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(dto.getIdEmpresa());
        empresa.setIdUbicacionINEI(dto.getIdUbicacionINEI());
        empresa.setNombreEmpresa(dto.getNombreEmpresa());
        empresa.setRuc(dto.getRuc());
        empresa.setDireccion(dto.getDireccion());
        empresa.setRepresentanteLegal(dto.getRepresentanteLegal());
        empresa.setNPartidaEmpresa(dto.getNPartidaEmpresa());
        return empresa;
    }
}
