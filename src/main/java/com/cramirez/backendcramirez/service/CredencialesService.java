package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.entity.Credenciales;
import com.cramirez.backendcramirez.repository.CredencialesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredencialesService {

    private final CredencialesRepository credencialesRepository;

    public CredencialesService(CredencialesRepository credencialesRepository) {
        this.credencialesRepository = credencialesRepository;
    }

    public Optional<Credenciales> encontrarPorUsuario(String usuario) {
        return credencialesRepository.findByUsuario(usuario);
    }

}
