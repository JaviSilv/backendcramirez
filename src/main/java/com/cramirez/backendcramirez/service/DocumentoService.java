package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.DocumentoDTO;
import com.cramirez.backendcramirez.entity.Documento;
import com.cramirez.backendcramirez.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public List<DocumentoDTO> obtenerTodosLosDocumentos() {
        return documentoRepository.findAll().stream()
                .map(this::convertirA_DTO)
                .collect(Collectors.toList());
    }

    public DocumentoDTO obtenerDocumentoPorId(int id) {
        return documentoRepository.findById(id)
                .map(this::convertirA_DTO)
                .orElse(null);
    }

    public DocumentoDTO crearDocumento(DocumentoDTO documentoDTO) {
        Documento documento = convertirA_Entidad(documentoDTO);
        Documento documentoGuardado = documentoRepository.save(documento);
        return convertirA_DTO(documentoGuardado);
    }

    public DocumentoDTO actualizarDocumento(int id, DocumentoDTO documentoDTO) {
        return documentoRepository.findById(id)
                .map(documento -> {
                    documento.setCartaNoAdeudo(documentoDTO.getCartaNoAdeudo());
                    documento.setCertificadoLote(documentoDTO.getCertificadoLote());
                    documento.setMediosPago(documentoDTO.getMediosPago());
                    documento.setMinutaEscaneada(documentoDTO.getMinutaEscaneada());
                    Documento documentoActualizado = documentoRepository.save(documento);
                    return convertirA_DTO(documentoActualizado);
                })
                .orElse(null);
    }

    public void eliminarDocumento(int id) {
        documentoRepository.deleteById(id);
    }

    private DocumentoDTO convertirA_DTO(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setIdDocumento(documento.getIdDocumento());
        dto.setCartaNoAdeudo(documento.getCartaNoAdeudo());
        dto.setCertificadoLote(documento.getCertificadoLote());
        dto.setMediosPago(documento.getMediosPago());
        dto.setMinutaEscaneada(documento.getMinutaEscaneada());
        return dto;
    }

    private Documento convertirA_Entidad(DocumentoDTO dto) {
        Documento documento = new Documento();
        documento.setIdDocumento(dto.getIdDocumento());
        documento.setCartaNoAdeudo(dto.getCartaNoAdeudo());
        documento.setCertificadoLote(dto.getCertificadoLote());
        documento.setMediosPago(dto.getMediosPago());
        documento.setMinutaEscaneada(dto.getMinutaEscaneada());
        return documento;
    }
}
