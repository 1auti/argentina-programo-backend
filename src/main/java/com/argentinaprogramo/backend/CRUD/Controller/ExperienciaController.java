package com.argentinaprogramo.backend.CRUD.Controller;

import com.argentinaprogramo.backend.CRUD.DTO.ExperienciaDto;
import com.argentinaprogramo.backend.CRUD.Entity.Experiencia;
import com.argentinaprogramo.backend.CRUD.Service.ExperienciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exp")
@CrossOrigin("http://localhost:4200")
public class ExperienciaController {

    @Autowired
    private ExperienciaService service;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){
        if(StringUtils.isBlank(experienciaDto.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if (service.exitsByNombre(experienciaDto.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(experienciaDto.getNombre(), experienciaDto.getDescripcion());
        service.save(experiencia);

        return  new ResponseEntity(HttpStatus.OK);


    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Integer id,@RequestBody ExperienciaDto experienciatoDto){
        if(!service.existsById(id)){
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if(service.exitsByNombre(experienciatoDto.getNombre()) && service.getByNombre(experienciatoDto.getNombre()).get().getId() != id){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(experienciatoDto.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = service.getOne(id).get();
        experiencia.setNombre(experienciatoDto.getNombre());
        experiencia.setDescripcion(experienciatoDto.getDescripcion());

        service.save(experiencia);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delate(@PathVariable ("id") Integer id){

        if(!service.existsById(id)){
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        service.delate(id);

        return  new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Experiencia experiencia = service.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }


}
