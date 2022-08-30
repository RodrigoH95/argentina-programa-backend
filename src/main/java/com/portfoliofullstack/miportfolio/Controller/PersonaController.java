package com.portfoliofullstack.miportfolio.Controller;

import com.portfoliofullstack.miportfolio.Models.Persona;
import com.portfoliofullstack.miportfolio.Service.PersonaService;
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
@CrossOrigin(origins = "https://rodrigo-heredia.firebaseapp.com/")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("personas/perfil")
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }
    
    @GetMapping("personas/perfil/{id}")
    public Persona findPersona(@PathVariable("id") Long id) {
        // La id 1 corresponde al perfil principal
        Persona persona = personaService.findPersona(id);
        return persona;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear-persona")
    public String createPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
        return "Persona creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/eliminar-persona/{id}")
    public String deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return "Persona eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar-persona/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestBody Persona pers) {

        Persona persona = personaService.findPersona(id);

        persona.setNombre(pers.getNombre());
        persona.setApellido(pers.getApellido());
        persona.setTitulo(pers.getTitulo());
        persona.setDescripcion(pers.getDescripcion());
        persona.setImg(pers.getImg());
        persona.setImgBanner(pers.getImgBanner());

        personaService.savePersona(persona);
        return persona;
    }

}
