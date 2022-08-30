package com.portfoliofullstack.miportfolio.Controller;

import com.portfoliofullstack.miportfolio.Models.Experiencia;
import com.portfoliofullstack.miportfolio.Service.ExperienciaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://rodrigo-heredia.web.app/")
public class ExperienciaController {

    @Autowired
    ExperienciaService expService;

    @GetMapping("personas/experiencia")
    public List<Experiencia> getExperiencia() {
        return expService.getExperiencia();
    }

    @GetMapping("personas/experiencia/{id}")
    public Experiencia findExperiencia(@PathVariable Long id) {
        return expService.findExperiencia(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear-experiencia")
    public void addExperiencia(@RequestBody Experiencia experiencia) {
        expService.addExperiencia(experiencia);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar-experiencia/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
            @RequestBody Experiencia exp) {

        Experiencia experiencia = expService.findExperiencia(id);

        experiencia.setNombreExp(exp.getNombreExp());
        experiencia.setDescExp(exp.getDescExp());
        experiencia.setInicioExp(exp.getInicioExp());
        experiencia.setFinExp(exp.getFinExp());
        experiencia.setImagenExp(exp.getImagenExp());

        return expService.addExperiencia(experiencia);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/eliminar-experiencia/{id}")
    public void deleteExperiencia(@PathVariable Long id) {
        expService.deleteExperiencia(id);
    }
}
