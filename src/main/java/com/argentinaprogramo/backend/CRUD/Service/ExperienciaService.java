package com.argentinaprogramo.backend.CRUD.Service;

import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import com.argentinaprogramo.backend.CRUD.Repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ExperienciaService {

   List<Experiencia> list();
   Optional<Experiencia> getOne(Integer id);
   Optional<Experiencia> getByNombre(String nombre);
   void save(Experiencia experiencia);
   void delate(Integer id);
   boolean existsById(Integer id);
   boolean exitsByNombre(String nombre);



}
