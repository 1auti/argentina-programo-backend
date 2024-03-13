package com.argentinaprogramo.backend.CRUD.Repository;

import com.argentinaprogramo.backend.CRUD.Entity.Educacion;
import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion,Integer> {

    Optional<Educacion> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
