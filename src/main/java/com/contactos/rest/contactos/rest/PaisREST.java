package com.contactos.rest.contactos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.rest.contactos.model.Pais;
import com.contactos.rest.contactos.service.PaisService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://angular-contactos.vercel.app"})
@RequestMapping("/pais/")
public class PaisREST {

    @Autowired
    private PaisService paisService;

    @GetMapping
    private ResponseEntity<List<Pais>> getAllPaises(){
        return ResponseEntity.ok(paisService.findAll());
    }
}
