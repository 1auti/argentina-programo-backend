package com.argentinaprogramo.backend.CRUD.Repository;

import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia,Integer> {

     Optional<Experiencia> findByNombre(String nombre);
     boolean existsByNombre(String nombre);

}
