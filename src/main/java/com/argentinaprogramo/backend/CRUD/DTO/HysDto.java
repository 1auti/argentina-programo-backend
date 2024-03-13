package com.argentinaprogramo.backend.CRUD.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HysDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

}
