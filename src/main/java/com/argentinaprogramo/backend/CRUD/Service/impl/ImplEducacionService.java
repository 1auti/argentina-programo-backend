package com.argentinaprogramo.backend.CRUD.Service.impl;

import com.argentinaprogramo.backend.CRUD.Entity.Educacion;
import com.argentinaprogramo.backend.CRUD.Repository.EducacionRepository;
import com.argentinaprogramo.backend.CRUD.Service.EducacionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImplEducacionService implements EducacionService {


    @Autowired
    EducacionRepository repository;

    @Override
    public List<Educacion> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Educacion> getOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Educacion> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public void save(Educacion educacion) {
        repository.save(educacion);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }
}
