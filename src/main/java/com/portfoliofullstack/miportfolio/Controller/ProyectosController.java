package com.portfoliofullstack.miportfolio.Controller;

import com.portfoliofullstack.miportfolio.Models.Proyecto;
import com.portfoliofullstack.miportfolio.Service.ProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-arg-programa-rh95.web.app/")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("personas/proyectos")
    public List<Proyecto> getProyectos() {
        return proyectosService.getProyectos();
    }

    @GetMapping("personas/proyectos/{id}")
    public Proyecto findProyecto(@PathVariable Long id) {
        return proyectosService.findProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear-proyecto")
    public void crearProyecto(@RequestBody Proyecto proyecto) {
        proyectosService.saveProyecto(proyecto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar-proyecto/{id}")
    public Proyecto editProyecto(@PathVariable("id") Long id, @RequestBody Proyecto pro) {
        Proyecto proyecto = proyectosService.findProyecto(id);
        proyecto.setTituloProyecto(pro.getTituloProyecto());
        proyecto.setDescProyecto(pro.getDescProyecto());
        proyecto.setUrlProyecto(pro.getUrlProyecto());
        proyecto.setImagenProyecto(pro.getImagenProyecto());

        proyectosService.saveProyecto(proyecto);

        return proyecto;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/eliminar-proyecto/{id}")
    public void deleteProyecto(@PathVariable("id") Long id) {
        proyectosService.deleteProyecto(id);
    }
}
