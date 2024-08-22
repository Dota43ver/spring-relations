package com.contactos.rest.contactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactos.rest.contactos.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Integer>{

}
