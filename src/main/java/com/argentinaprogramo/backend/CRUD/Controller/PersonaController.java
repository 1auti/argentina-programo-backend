package com.argentinaprogramo.backend.CRUD.Controller;

import com.argentinaprogramo.backend.CRUD.DTO.PersonaDto;
import com.argentinaprogramo.backend.CRUD.Entity.Persona;
import com.argentinaprogramo.backend.CRUD.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("personas/traer")
    public List<Persona> getPersonas(){
        return service.getPersonas();
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona persona){
        service.savePersona(persona);
        return  "Guardado con exito";
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("personas/borrar/{id}")
    public String delatePersona(@PathVariable    Long id){
        service.delatePersona(id);
        return  "Eliminado con exito";
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("personas/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PersonaDto dtopersona){
        if(!service.existsById(id)){
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        if(service.exisstsByNombre(dtopersona.getNombre()) && service.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Persona persona = service.getOne(id).get();

        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());

        service.savePersona(persona);

        return new ResponseEntity(HttpStatus.OK);
    }



    @GetMapping("personas/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")Long id){
        if(!service.existsById(id)){
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }

        Persona persona = service.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }


    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return service.findPersona((long) 1);
    }

}
