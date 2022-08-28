package com.portfoliofullstack.miportfolio.Controller;

import com.portfoliofullstack.miportfolio.Models.Habilidades;
import com.portfoliofullstack.miportfolio.Service.HabilidadesService;
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
@CrossOrigin(origins = "https://portfolio-arg-programa-rh95.web.app/")
public class HabilidadesController {

    @Autowired
    HabilidadesService habService;

    @GetMapping("personas/habilidades")
    public List<Habilidades> getHabilidades() {
        return habService.getHabilidades();
    }

    @GetMapping("personas/habilidades/{id}")
    public Habilidades findHabilidades(@PathVariable Long id) {
        return habService.findHabilidades(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear-habilidad")
    public void addHabilidad(@RequestBody Habilidades habilidad) {
        habService.addHabilidades(habilidad);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar-habilidad/{id}")
    public Habilidades editHabilidad(@PathVariable Long id, @RequestBody Habilidades hab) {
        Habilidades habilidad = habService.findHabilidades(id);

        habilidad.setNombreHab(hab.getNombreHab());
        habilidad.setCategoria(hab.getCategoria());
        habilidad.setPorcentaje(hab.getPorcentaje());
        habilidad.setImagenHab(hab.getImagenHab());

        return habService.addHabilidades(habilidad);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/eliminar-habilidad/{id}")
    public void deleteHabilidad(@PathVariable Long id) {
        habService.deleteHabilidades(id);
    }
}
