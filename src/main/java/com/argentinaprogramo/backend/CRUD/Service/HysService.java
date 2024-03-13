package com.argentinaprogramo.backend.CRUD.Service;

import com.argentinaprogramo.backend.CRUD.Entity.Hys;

import java.util.List;
import java.util.Optional;

public interface HysService {

    List<Hys> list();
    Optional<Hys> getOne(Integer id);
    Optional<Hys> getByNombre(String nombre);
    void save(Hys skill);
    void delete(Integer id);
    boolean existsById(Integer id);
    boolean exisstsByNombre(String nombre);


}
