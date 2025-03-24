package com.cramirez.backendcramirez.controller;


import com.cramirez.backendcramirez.dto.DetallesLoteDTO;
import com.cramirez.backendcramirez.service.DetallesLoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesLote")
public class DetallesLoteController {

    @Autowired
    private DetallesLoteService detallesLoteService;

    @GetMapping
    public List<DetallesLoteDTO> obtenerTodos() {
        return detallesLoteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public DetallesLoteDTO obtenerPorId(@PathVariable int id) {
        return detallesLoteService.obtenerPorId(id);
    }

    @PostMapping
    public DetallesLoteDTO guardar(@RequestBody DetallesLoteDTO detallesLoteDTO) {
        return detallesLoteService.guardar(detallesLoteDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        detallesLoteService.eliminar(id);
    }
}
