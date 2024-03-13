package com.argentinaprogramo.backend.CRUD.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nombre;
    private String descripcion;

    public Educacion(String nombre,String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
