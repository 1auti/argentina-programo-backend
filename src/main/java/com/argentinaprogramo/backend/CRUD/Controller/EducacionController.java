package com.argentinaprogramo.backend.CRUD.Controller;

import com.argentinaprogramo.backend.CRUD.DTO.EducacionDto;
import com.argentinaprogramo.backend.CRUD.DTO.ExperienciaDto;
import com.argentinaprogramo.backend.CRUD.Entity.Educacion;
import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import com.argentinaprogramo.backend.CRUD.Service.EducacionService;
import com.argentinaprogramo.backend.CRUD.Service.ExperienciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educacion/")
@CrossOrigin("http://localhost:4200")
public class EducacionController {

    @Autowired
    EducacionService service;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
        if(StringUtils.isBlank(educacionDto.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if (service.existsByNombre(educacionDto.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

       Educacion educacion = new Educacion(educacionDto.getNombre(), educacionDto.getDescripcion());
        service.save(educacion);

        return  new ResponseEntity(HttpStatus.OK);


    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Integer id,@RequestBody EducacionDto educacionDto){
        if(!service.existsById(id)){
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if(service.existsByNombre(educacionDto.getNombre()) && service.getByNombre(educacionDto.getNombre()).get().getId() != id){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(educacionDto.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = service.getOne(id).get();
        educacion.setNombre(educacion.getNombre());
        educacion.setDescripcion(educacionDto.getDescripcion());

        service.save(educacion);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delate(@PathVariable ("id") Integer id){

        if(!service.existsById(id)){
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        service.delete(id);

        return  new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Integer id){
        if(!service.existsById(id))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Educacion educacion = service.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
