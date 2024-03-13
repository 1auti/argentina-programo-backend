package com.argentinaprogramo.backend.CRUD.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExperienciaDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;


}
