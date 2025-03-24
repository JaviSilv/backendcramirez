package com.cramirez.backendcramirez.controller;

import com.cramirez.backendcramirez.dto.CitaDTO;
import com.cramirez.backendcramirez.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> obtenerTodasLasCitas() {
        return ResponseEntity.ok(citaService.obtenerTodasLasCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> obtenerCitaPorId(@PathVariable int id) {
        return ResponseEntity.ok(citaService.obtenerCitaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crearCita(@RequestBody CitaDTO citaDTO) {
        return ResponseEntity.ok(citaService.crearCita(citaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> actualizarCita(@PathVariable int id, @RequestBody CitaDTO citaDTO) {
        return ResponseEntity.ok(citaService.actualizarCita(id, citaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable int id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }
}
