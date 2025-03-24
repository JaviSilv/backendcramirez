package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.LoteDTO;
import com.cramirez.backendcramirez.entity.Lote;
import com.cramirez.backendcramirez.repository.LoteRepository;
import com.cramirez.backendcramirez.repository.ProyectoRepository;
import com.cramirez.backendcramirez.repository.TipoContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoteService {

    private final LoteRepository loteRepository;
    private final TipoContratoRepository tipoContratoRepository;
    private final ProyectoRepository proyectoRepository;

    @Autowired
    public LoteService(LoteRepository loteRepository, TipoContratoRepository tipoContratoRepository, ProyectoRepository proyectoRepository) {
        this.loteRepository = loteRepository;
        this.tipoContratoRepository = tipoContratoRepository;
        this.proyectoRepository = proyectoRepository;
    }

    public List<LoteDTO> getAllLotes() {
        List<Lote> lotes = loteRepository.findAll();
        return lotes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<LoteDTO> getLoteById(Integer id) {
        return loteRepository.findById(id).map(this::convertToDTO);
    }

    public LoteDTO saveLote(LoteDTO loteDTO) {
        Lote lote = convertToEntity(loteDTO);
        Lote savedLote = loteRepository.save(lote);
        return convertToDTO(savedLote);
    }

    public Optional<LoteDTO> getUltimoLote() {
        return loteRepository.findTopByOrderByIdLoteDesc()
                .map(this::convertToDTO);
    }


    public void deleteLote(Integer id) {
        loteRepository.deleteById(id);
    }

    private LoteDTO convertToDTO(Lote lote) {
        LoteDTO dto = new LoteDTO();
        dto.setIdLote(lote.getIdLote());
        dto.setIdContrato(lote.getIdContrato());
        dto.setIdOperario(lote.getIdOperario());
        dto.setIdProyecto(lote.getIdProyecto());
        dto.setIdClienteLote(lote.getIdClienteLote());
        dto.setNumeroLote(lote.getNumeroLote());
        dto.setManzana(lote.getManzana());
        dto.setAreaLote(lote.getAreaLote());
        dto.setUbicacion(lote.getUbicacion());
        dto.setUnidadCatastral(lote.getUnidadCatastral());
        dto.setPartidaLoteMatriz(lote.getPartidaLoteMatriz());
        dto.setUrbanizacion(lote.getUrbanizacion());

        dto.setNombreProyecto(obtenerTexto(proyectoRepository.findById(lote.getIdProyecto()), "NombreProyecto"));
        dto.setTipoContrato(obtenerTexto(tipoContratoRepository.findById(lote.getIdContrato()), "TipoContrato"));

        return dto;
    }

    private String obtenerTexto(Optional<?> entidad, String campo) {
        return entidad.map(e -> {
            try {
                return e.getClass().getMethod("get" + campo).invoke(e).toString();
            } catch (Exception ex) {
                return null;
            }
        }).orElse(null);
    }

    private Lote convertToEntity(LoteDTO dto) {
        Lote lote = new Lote();
        lote.setIdContrato(dto.getIdContrato());
        lote.setIdProyecto(dto.getIdProyecto());
        lote.setIdOperario(dto.getIdOperario());
        lote.setIdClienteLote(dto.getIdClienteLote());
        lote.setManzana(dto.getManzana());
        lote.setNumeroLote(dto.getNumeroLote());
        lote.setAreaLote(dto.getAreaLote());
        lote.setUbicacion(dto.getUbicacion());
        lote.setUnidadCatastral(dto.getUnidadCatastral());
        lote.setPartidaLoteMatriz(dto.getPartidaLoteMatriz());
        lote.setUrbanizacion(dto.getUrbanizacion());
        return lote;
    }
}
