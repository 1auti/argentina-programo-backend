package com.argentinaprogramo.backend.CRUD.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducacionDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String Descripcion;

}
