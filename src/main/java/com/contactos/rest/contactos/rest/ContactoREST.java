package com.contactos.rest.contactos.rest;

import org.springframework.web.bind.annotation.RestController;

import com.contactos.rest.contactos.model.Contacto;
import com.contactos.rest.contactos.service.ContactoService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://landing-angular-five.vercel.app/"})
@RequestMapping("/contactos/")
public class ContactoREST {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    private ResponseEntity<List<Contacto>> getAllContactos(){
        return ResponseEntity.ok(contactoService.findAll());
    }

    @PostMapping
    private ResponseEntity<Contacto> saveContacto(@RequestBody Contacto contacto){
        Contacto contactoGuardado = contactoService.save(contacto);
        try {
            return ResponseEntity.created(new URI("/contactos/"+ contactoGuardado.getId())).body(contactoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }
}
