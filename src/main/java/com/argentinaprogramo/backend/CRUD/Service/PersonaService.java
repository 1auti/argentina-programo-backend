package com.argentinaprogramo.backend.CRUD.Service;

import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import com.argentinaprogramo.backend.CRUD.Entity.Hys;
import com.argentinaprogramo.backend.CRUD.Entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<Persona> getPersonas();
    void savePersona(Persona persona);
    void delatePersona(Long id);
    Persona findPersona(Long id);
    boolean existsById(Long id);
    boolean exisstsByNombre(String nombre);
    Optional<Persona> getOne(Long id);
    Optional<Persona> getByNombre(String nombre);




}
