package com.cramirez.backendcramirez.controller;

import com.cramirez.backendcramirez.dto.ResidenciaDTO;
import com.cramirez.backendcramirez.service.ResidenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residencia")
public class ResidenciaController {
    private final ResidenciaService residenciaService;

    public ResidenciaController(ResidenciaService residenciaService) {
        this.residenciaService = residenciaService;
    }

    @GetMapping
    public List<ResidenciaDTO> getAllResidencias() {
        return residenciaService.getAllResidencias();
    }

    @GetMapping("/{id}")
    public ResidenciaDTO getResidenciaById(@PathVariable int id) {
        return residenciaService.getResidenciaById(id);
    }

    @PostMapping
    public ResidenciaDTO createResidencia(@RequestBody ResidenciaDTO residencia) {
        return residenciaService.createResidencia(residencia);
    }
}