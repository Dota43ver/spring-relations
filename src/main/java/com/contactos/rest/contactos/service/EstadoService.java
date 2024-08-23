package com.contactos.rest.contactos.service;


import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.contactos.rest.contactos.model.Estado;
import com.contactos.rest.contactos.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public List<Estado> findAllByCountry(Long countryId) {
        return estadoRepository.findAll().stream()
            .filter(estado -> Objects.equals(estado.getPais().getId(), countryId))
            .collect(Collectors.toList());
    }
    
}

