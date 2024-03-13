package com.argentinaprogramo.backend.CRUD.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre" , length = 60 , nullable = false)
    private String nombre;

    @Column (name = "apellido" , length = 60 , nullable = false)
    private String apellido;

    @Column (name = "descripcion",length = 60,nullable = false)
    private String descripcion;

    @Column( name = "img" , length = 60 , nullable = false)
    private String img;


}
