package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.CopropietarioConyugeDTO;
import com.cramirez.backendcramirez.entity.CopropietarioConyuge;
import com.cramirez.backendcramirez.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CopropietarioConyugeService {

    private final CopropietarioConyugeRepository copropietarioConyugeRepository;
    private final CopropietarioRepository copropietarioRepository;
    private final OperarioRepository operarioRepository;
    private final PrefijotelefonicoRepository prefijotelefonicoRepository;
    private final IdentificacionRepository identificacionRepository;
    private final OcupacionRepository ocupacionRepository;
    private final NacionalidadRepository nacionalidadRepository;
    private final ResidenciaRepository residenciaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ProvinciaRepository provinciaRepository;
    private final DistritoRepository distritoRepository;

    @Autowired
    public CopropietarioConyugeService(CopropietarioConyugeRepository copropietarioConyugeRepository, CopropietarioRepository copropietarioRepository, OperarioRepository operarioRepository, PrefijotelefonicoRepository prefijotelefonicoRepository, IdentificacionRepository identificacionRepository, OcupacionRepository ocupacionRepository, NacionalidadRepository nacionalidadRepository, ResidenciaRepository residenciaRepository, DepartamentoRepository departamentoRepository, ProvinciaRepository provinciaRepository, DistritoRepository distritoRepository) {
        this.copropietarioConyugeRepository = copropietarioConyugeRepository;
        this.copropietarioRepository = copropietarioRepository;
        this.operarioRepository = operarioRepository;
        this.prefijotelefonicoRepository = prefijotelefonicoRepository;
        this.identificacionRepository = identificacionRepository;
        this.ocupacionRepository = ocupacionRepository;
        this.nacionalidadRepository = nacionalidadRepository;
        this.residenciaRepository = residenciaRepository;
        this.departamentoRepository = departamentoRepository;
        this.provinciaRepository = provinciaRepository;
        this.distritoRepository = distritoRepository;
    }

    // Guardar un nuevo CopropietarioConyuge
    public CopropietarioConyugeDTO guardarCopropietarioConyuge(CopropietarioConyugeDTO dto) {
        CopropietarioConyuge entidad = convertirAEntidad(dto);
        CopropietarioConyuge guardado = copropietarioConyugeRepository.save(entidad);
        return convertirADTO(guardado);
    }

    // Obtener todos los CopropietarioConyuge
    public List<CopropietarioConyugeDTO> obtenerTodos() {
        return copropietarioConyugeRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Obtener un CopropietarioConyuge por ID
    public CopropietarioConyugeDTO obtenerPorId(int id) {
        return copropietarioConyugeRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    // Actualizar un CopropietarioConyuge
    public CopropietarioConyugeDTO actualizarCopropietarioConyuge(int id, CopropietarioConyugeDTO dto) {
        return copropietarioConyugeRepository.findById(id)
                .map(entidad -> {
                    actualizarEntidad(entidad, dto);
                    CopropietarioConyuge actualizado = copropietarioConyugeRepository.save(entidad);
                    return convertirADTO(actualizado);
                })
                .orElse(null);
    }

    // Eliminar un CopropietarioConyuge
    public void eliminarCopropietarioConyuge(int id) {
        copropietarioConyugeRepository.deleteById(id);
    }

    // Conversión de Entidad a DTO
    private CopropietarioConyugeDTO convertirADTO(CopropietarioConyuge entidad) {
        CopropietarioConyugeDTO dto = new CopropietarioConyugeDTO();
        dto.setIdCopropietarioConyuge(entidad.getIdCopropietarioConyuge());
        dto.setIdClienteCopropietarioConyuge(entidad.getIdClienteCopropietarioConyuge());
        dto.setIdOcupacionCopropietarioConyuge(entidad.getIdOcupacionCopropietarioConyuge());
        dto.setIdResidenciaCopropietarioConyuge(entidad.getIdResidenciaCopropietarioConyuge());
        dto.setIdPrefijoCopropietarioConyuge(entidad.getIdPrefijoCopropietarioConyuge());
        dto.setIdOperarioCopropietarioConyuge(entidad.getIdOperarioCopropietarioConyuge());
        dto.setIdDistritoCopropietarioConyuge(entidad.getIdDistritoCopropietarioConyuge());
        dto.setIdProvinciaCopropietarioConyuge(entidad.getIdProvinciaCopropietarioConyuge());
        dto.setIdDepartamentoCopropietarioConyuge(entidad.getIdDepartamentoCopropietarioConyuge());
        dto.setIdNacionalidadCopropietarioConyuge(entidad.getIdNacionalidadCopropietarioConyuge());
        dto.setIdIdentificacionCopropietarioConyuge(entidad.getIdIdentificacionCopropietarioConyuge());
        dto.setNombresApellidosCopropietarioConyuge(entidad.getNombresApellidosCopropietarioConyuge());
        dto.setDireccionCopropietarioConyuge(entidad.getDireccionCopropietarioConyuge());
        dto.setCorreoElectronicoCopropietarioConyuge(entidad.getCorreoElectronicoCopropietarioConyuge());
        dto.setCelularCopropietarioConyuge(entidad.getCelularCopropietarioConyuge());
        dto.setNumeroIdentificacionCopropietarioConyuge(entidad.getNumeroIdentificacionCopropietarioConyuge());

        dto.setOperarioCopropietarioConyuge(obtenerTexto(operarioRepository.findById(entidad.getIdOperarioCopropietarioConyuge()), "TipoOperario"));
        dto.setPrefijoPaisCopropietarioConyuge(obtenerTexto(prefijotelefonicoRepository.findById(entidad.getIdPrefijoCopropietarioConyuge()), "PrefijoPais"));
        dto.setDocumentoIdentificacionCopropietarioConyuge(obtenerTexto(identificacionRepository.findById(entidad.getIdIdentificacionCopropietarioConyuge()), "DocumentoIdentificacion"));
        dto.setOcupacionCopropietarioConyuge(obtenerTexto(ocupacionRepository.findById(entidad.getIdOcupacionCopropietarioConyuge()), "NombreOcupacion"));
        dto.setNacionalidadCopropietarioConyuge(obtenerTexto(nacionalidadRepository.findById(entidad.getIdNacionalidadCopropietarioConyuge()), "NombreNacionalidad"));
        dto.setResidenciaCopropietarioConyuge(obtenerTexto(residenciaRepository.findById(entidad.getIdResidenciaCopropietarioConyuge()), "Residencia"));
        dto.setDepartamentoCopropietarioConyuge(obtenerTexto(departamentoRepository.findById(entidad.getIdDepartamentoCopropietarioConyuge()), "NombreDepartamento"));
        dto.setProvinciaCopropietarioConyuge(obtenerTexto(provinciaRepository.findById(entidad.getIdProvinciaCopropietarioConyuge()), "NombreProvincia"));
        dto.setDistritoCopropietarioConyuge(obtenerTexto(distritoRepository.findById(entidad.getIdDistritoCopropietarioConyuge()), "NombreDistrito"));


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


    // Conversión de DTO a Entidad
    private CopropietarioConyuge convertirAEntidad(CopropietarioConyugeDTO dto) {
        CopropietarioConyuge entidad = new CopropietarioConyuge();
        actualizarEntidad(entidad, dto);
        return entidad;
    }

    // Actualizar la entidad desde el DTO
    private void actualizarEntidad(CopropietarioConyuge entidad, CopropietarioConyugeDTO dto) {
        entidad.setIdClienteCopropietarioConyuge(dto.getIdClienteCopropietarioConyuge());
        entidad.setIdOcupacionCopropietarioConyuge(dto.getIdOcupacionCopropietarioConyuge());
        entidad.setIdResidenciaCopropietarioConyuge(dto.getIdResidenciaCopropietarioConyuge());
        entidad.setIdPrefijoCopropietarioConyuge(dto.getIdPrefijoCopropietarioConyuge());
        entidad.setIdOperarioCopropietarioConyuge(dto.getIdOperarioCopropietarioConyuge());
        entidad.setIdDistritoCopropietarioConyuge(dto.getIdDistritoCopropietarioConyuge());
        entidad.setIdProvinciaCopropietarioConyuge(dto.getIdProvinciaCopropietarioConyuge());
        entidad.setIdDepartamentoCopropietarioConyuge(dto.getIdDepartamentoCopropietarioConyuge());
        entidad.setIdNacionalidadCopropietarioConyuge(dto.getIdNacionalidadCopropietarioConyuge());
        entidad.setIdIdentificacionCopropietarioConyuge(dto.getIdIdentificacionCopropietarioConyuge());
        entidad.setNombresApellidosCopropietarioConyuge(dto.getNombresApellidosCopropietarioConyuge());
        entidad.setDireccionCopropietarioConyuge(dto.getDireccionCopropietarioConyuge());
        entidad.setCorreoElectronicoCopropietarioConyuge(dto.getCorreoElectronicoCopropietarioConyuge());
        entidad.setCelularCopropietarioConyuge(dto.getCelularCopropietarioConyuge());
        entidad.setNumeroIdentificacionCopropietarioConyuge(dto.getNumeroIdentificacionCopropietarioConyuge());
    }
}
