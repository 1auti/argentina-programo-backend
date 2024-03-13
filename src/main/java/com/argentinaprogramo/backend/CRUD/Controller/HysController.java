package com.argentinaprogramo.backend.CRUD.Controller;

import com.argentinaprogramo.backend.CRUD.DTO.HysDto;
import com.argentinaprogramo.backend.CRUD.Entity.Hys;
import com.argentinaprogramo.backend.CRUD.Service.HysService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
@CrossOrigin("http://localhost:4200")
public class HysController {

    @Autowired
    HysService service;

    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list() {
        List<Hys> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Hys hYs = service.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (!service.existsById(id)) {
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HysDto dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }
        if (service.exisstsByNombre(dtohys.getNombre())) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }

        Hys hYs = new Hys(dtohys.getNombre(), dtohys.getPorcentaje());
        service.save(hYs);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody HysDto dtohys) {
        //Validamos si existe el ID
        if (!service.existsById(id)) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (service.exisstsByNombre(dtohys.getNombre()) && service.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }

        Hys hYs = service.getOne(id).get();
        hYs.setNombre(dtohys.getNombre());
        hYs.setPorcentaje(dtohys.getPorcentaje());

        service.save(hYs);
        return new ResponseEntity(HttpStatus.OK);

    }



}
