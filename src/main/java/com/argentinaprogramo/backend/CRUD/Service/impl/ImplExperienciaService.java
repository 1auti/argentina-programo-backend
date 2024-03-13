package com.argentinaprogramo.backend.CRUD.Service.impl;

import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import com.argentinaprogramo.backend.CRUD.Repository.ExperienciaRepository;
import com.argentinaprogramo.backend.CRUD.Service.ExperienciaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImplExperienciaService implements ExperienciaService {


   @Autowired
   ExperienciaRepository repository;

   @Override
    public List<Experiencia> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Experiencia> getOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Experiencia> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public void save(Experiencia exp) {
      repository.save(exp);
    }

    @Override
    public void delate(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public  boolean exitsByNombre(String nombre){
        return repository.existsByNombre(nombre);
    }
}
