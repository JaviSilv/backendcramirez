package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.DetallesLoteDTO;
import com.cramirez.backendcramirez.entity.DetallesLote;
import com.cramirez.backendcramirez.repository.DetallesLoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetallesLoteService {

    @Autowired
    private DetallesLoteRepository detallesLoteRepository;

    public List<DetallesLoteDTO> obtenerTodos() {
        List<DetallesLote> detallesLotes = detallesLoteRepository.findAll();
        return detallesLotes.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DetallesLoteDTO obtenerPorId(int id) {
        Optional<DetallesLote> detallesLote = detallesLoteRepository.findById(id);
        return detallesLote.map(this::convertirADTO).orElse(null);
    }

    public DetallesLoteDTO guardar(DetallesLoteDTO detallesLoteDTO) {
        DetallesLote detallesLote = convertirAEntidad(detallesLoteDTO);
        detallesLote = detallesLoteRepository.save(detallesLote);
        return convertirADTO(detallesLote);
    }

    public void eliminar(int id) {
        detallesLoteRepository.deleteById(id);
    }

    private DetallesLoteDTO convertirADTO(DetallesLote detallesLote) {
        DetallesLoteDTO dto = new DetallesLoteDTO();
        dto.setIdLote(detallesLote.getIdLote());
        dto.setCostoLote(detallesLote.getCostoLote());
        dto.setPagoInicialLote(detallesLote.getPagoInicialLote());
        dto.setSeparacionLote(detallesLote.getSeparacionLote());
        dto.setCantidadCuotaLote(detallesLote.getCantidadCuotaLote());
        dto.setCuotasExtraordinariasLote(detallesLote.getCuotasExtraordinariasLote());
        dto.setMantenimientoMensualLote(detallesLote.getMantenimientoMensualLote());
        return dto;
    }

    private DetallesLote convertirAEntidad(DetallesLoteDTO dto) {
        DetallesLote detallesLote = new DetallesLote();
        detallesLote.setIdLote(dto.getIdLote());
        detallesLote.setCostoLote(dto.getCostoLote());
        detallesLote.setPagoInicialLote(dto.getPagoInicialLote());
        detallesLote.setSeparacionLote(dto.getSeparacionLote());
        detallesLote.setCantidadCuotaLote(dto.getCantidadCuotaLote());
        detallesLote.setCuotasExtraordinariasLote(dto.getCuotasExtraordinariasLote());
        detallesLote.setMantenimientoMensualLote(dto.getMantenimientoMensualLote());
        return detallesLote;
    }
}