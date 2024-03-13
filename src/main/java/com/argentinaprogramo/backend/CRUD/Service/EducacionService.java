package com.argentinaprogramo.backend.CRUD.Service;

import com.argentinaprogramo.backend.CRUD.Entity.Educacion;
import com.argentinaprogramo.backend.CRUD.Entity.Hys;

import java.util.List;
import java.util.Optional;

public interface EducacionService {

    List<Educacion> list();
    Optional<Educacion> getOne(Integer id);
    Optional<Educacion> getByNombre(String nombre);
    void save(Educacion educacion);
    void delete(Integer id);
    boolean existsById(Integer id);
    boolean existsByNombre(String nombre);
}
