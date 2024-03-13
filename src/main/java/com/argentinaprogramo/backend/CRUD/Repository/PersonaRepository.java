package com.argentinaprogramo.backend.CRUD.Repository;

import com.argentinaprogramo.backend.CRUD.Entity.Educacion;
import com.argentinaprogramo.backend.CRUD.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    Optional<Persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
