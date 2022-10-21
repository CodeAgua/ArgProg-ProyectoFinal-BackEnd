package com.portfolio.ler.Controller;

import com.portfolio.ler.Dto.dtoProyecto;
import com.portfolio.ler.Entity.Proyecto;
import com.portfolio.ler.Security.Controller.Mensaje;
import com.portfolio.ler.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {

    @Autowired
    SProyecto sproy;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sproy.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sproy.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto no existe."), HttpStatus.NOT_FOUND);
        }
        Proyecto proy = sproy.getOne(id).get();
        return new ResponseEntity(proy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sproy.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto que buscaste no existe."), HttpStatus.NOT_FOUND);
        }
        sproy.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente."), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy) {
        if (StringUtils.isBlank(dtoproy.getTituloP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sproy.existsByTituloP(dtoproy.getTituloP())) {
            return new ResponseEntity(new Mensaje("Este proyecto ya existe."), HttpStatus.BAD_REQUEST);
        }

        Proyecto proy = new Proyecto(dtoproy.getTituloP(), dtoproy.getDescripcionP(), dtoproy.getDemoP(),
                dtoproy.getRepoP(), dtoproy.getUrlimagenP());
        sproy.save(proy);

        return new ResponseEntity(new Mensaje("Proyecto agregado satisfactoriamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproy) {

        if (!sproy.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este ID no existe."), HttpStatus.BAD_REQUEST);
        }

        if (sproy.existsByTituloP(dtoproy.getTituloP()) && sproy.getByTituloP(dtoproy.getTituloP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este proyecto ya existe."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoproy.getTituloP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Proyecto proy = sproy.getOne(id).get();
        proy.setTituloP(dtoproy.getTituloP());
        proy.setDescripcionP(dtoproy.getDescripcionP());
        proy.setDemoP(dtoproy.getDemoP());
        proy.setRepoP(dtoproy.getRepoP());
        proy.setUrlimagenP(dtoproy.getUrlimagenP());

        sproy.save(proy);
        return new ResponseEntity(new Mensaje("Proyecto actualizado satisfactoriamente."), HttpStatus.OK);

    }
}
