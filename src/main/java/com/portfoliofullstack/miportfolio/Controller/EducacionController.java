package com.portfoliofullstack.miportfolio.Controller;

import com.portfoliofullstack.miportfolio.Models.Educacion;
import com.portfoliofullstack.miportfolio.Service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://rodrigo-heredia.firebaseapp.com/")
public class EducacionController {

    @Autowired
    EducacionService eduService;

    @GetMapping("personas/educacion")
    public List<Educacion> getEducacion() {
        return eduService.getEducacion();
    }

    @GetMapping("personas/educacion/{id}")
    public Educacion findEducacion(@PathVariable Long id) {
        return eduService.findEducacion(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear-educacion")
    public void addEducacion(@RequestBody Educacion educacion) {
        eduService.addEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar-educacion/{id}")
    public Educacion editEducacion(@PathVariable Long id,
            @RequestBody Educacion edu) {

        Educacion educacion = eduService.findEducacion(id);

        educacion.setNombreEdu(edu.getNombreEdu());
        educacion.setDescEdu(edu.getDescEdu());
        educacion.setInicioEdu(edu.getInicioEdu());
        educacion.setFinEdu(edu.getFinEdu());
        educacion.setImagenEdu(edu.getImagenEdu());

        return eduService.addEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/eliminar-educacion/{id}")
    public void deleteEducacion(@PathVariable Long id) {
        eduService.deleteEducacion(id);
    }
}
