package com.argentinaprogramo.backend.CRUD.Service.impl;

import com.argentinaprogramo.backend.CRUD.Entity.Hys;
import com.argentinaprogramo.backend.CRUD.Repository.HysRepository;
import com.argentinaprogramo.backend.CRUD.Service.HysService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImplHysService implements HysService {

    @Autowired
    HysRepository repository;

    @Override
    public List<Hys> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Hys> getOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Hys> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public void save(Hys skill) {
        repository.save(skill);
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
    public boolean exisstsByNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }
}
