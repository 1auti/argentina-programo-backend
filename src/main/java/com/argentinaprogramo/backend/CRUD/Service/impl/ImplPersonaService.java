package com.argentinaprogramo.backend.CRUD.Service.impl;

import com.argentinaprogramo.backend.CRUD.Entity.Hys;
import com.argentinaprogramo.backend.CRUD.Entity.Persona;
import com.argentinaprogramo.backend.CRUD.Repository.PersonaRepository;
import com.argentinaprogramo.backend.CRUD.Service.PersonaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImplPersonaService implements PersonaService {

    @Autowired
    private PersonaRepository repository;
    @Override
    public List<Persona> getPersonas() {
        return repository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        repository.save(persona);
    }

    @Override
    public void delatePersona(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = repository.findById(id).orElse(null);
        return  persona;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exisstsByNombre(String nombre) {
        return exisstsByNombre(nombre);
    }

    @Override
    public Optional<Persona> getOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Persona> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
}
