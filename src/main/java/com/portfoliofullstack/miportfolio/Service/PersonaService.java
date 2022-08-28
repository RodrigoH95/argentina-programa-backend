
package com.portfoliofullstack.miportfolio.Service;

import com.portfoliofullstack.miportfolio.Models.Persona;
import com.portfoliofullstack.miportfolio.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = ipersonaRepository.findAll();
        return listaPersonas;
    }
    
        public Persona findPersona(Long id) {
        return ipersonaRepository.findById(id).orElse(null);
    }

    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }
    
}
