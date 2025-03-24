package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.ContratoDTO;
import com.cramirez.backendcramirez.entity.Contrato;
import com.cramirez.backendcramirez.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    @Autowired
    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public List<ContratoDTO> obtenerTodosLosContratos() {
        List<Contrato> contratos = contratoRepository.findAll();
        return contratos.stream().map(this::convertirA_DTO).collect(Collectors.toList());
    }

    public ContratoDTO obtenerContratoPorId(int id) {
        return contratoRepository.findById(id)
                .map(this::convertirA_DTO)
                .orElse(null);
    }

    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        Contrato contrato = convertirA_Entidad(contratoDTO);
        Contrato contratoGuardado = contratoRepository.save(contrato);
        return convertirA_DTO(contratoGuardado);
    }

    public ContratoDTO actualizarContrato(int id, ContratoDTO contratoDTO) {
        return contratoRepository.findById(id)
                .map(contrato -> {
                    contrato.setIdContrato(contratoDTO.getIdContrato());
                    contrato.setIdLote(contratoDTO.getIdLote());
                    contrato.setIdTipoContrato(contratoDTO.getIdTipoContrato());
                    contrato.setIdCliente(contratoDTO.getIdCliente());
                    contrato.setIdDocumento(contratoDTO.getIdDocumento());
                    contrato.setFechaInicio(contratoDTO.getFechaInicio());
                    contrato.setFechaFin(contratoDTO.getFechaFin());
                    contrato.setEstado(contratoDTO.getEstado());
                    contrato.setSituacionLegal(contratoDTO.getSituacionLegal());
                    contrato.setConstanciaNoAdeudo(contratoDTO.getConstanciaNoAdeudo());
                    Contrato contratoActualizado = contratoRepository.save(contrato);
                    return convertirA_DTO(contratoActualizado);
                })
                .orElse(null);
    }

    public void eliminarContrato(int id) {
        contratoRepository.deleteById(id);
    }

    private ContratoDTO convertirA_DTO(Contrato contrato) {
        ContratoDTO dto = new ContratoDTO();
        dto.setIdContrato(contrato.getIdContrato());
        dto.setIdLote(contrato.getIdLote());
        dto.setIdTipoContrato(contrato.getIdTipoContrato());
        dto.setIdCliente(contrato.getIdCliente());
        dto.setIdDocumento(contrato.getIdDocumento());
        dto.setFechaInicio(contrato.getFechaInicio());
        dto.setFechaFin(contrato.getFechaFin());
        dto.setEstado(contrato.getEstado());
        dto.setSituacionLegal(contrato.getSituacionLegal());
        dto.setConstanciaNoAdeudo(contrato.getConstanciaNoAdeudo());
        return dto;
    }

    private Contrato convertirA_Entidad(ContratoDTO dto) {
        Contrato contrato = new Contrato();
        contrato.setIdContrato(dto.getIdContrato());
        contrato.setIdLote(dto.getIdLote());
        contrato.setIdTipoContrato(dto.getIdTipoContrato());
        contrato.setIdCliente(dto.getIdCliente());
        contrato.setIdDocumento(dto.getIdDocumento());
        contrato.setFechaInicio(dto.getFechaInicio());
        contrato.setFechaFin(dto.getFechaFin());
        contrato.setEstado(dto.getEstado());
        contrato.setSituacionLegal(dto.getSituacionLegal());
        contrato.setConstanciaNoAdeudo(dto.getConstanciaNoAdeudo());
        return contrato;
    }
}
