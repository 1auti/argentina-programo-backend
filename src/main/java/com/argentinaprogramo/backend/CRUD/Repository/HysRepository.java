package com.argentinaprogramo.backend.CRUD.Repository;

import com.argentinaprogramo.backend.CRUD.Entity.Hys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HysRepository extends JpaRepository<Hys,Integer> {

    Optional<Hys> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
