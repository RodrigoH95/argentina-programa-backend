package com.portfoliofullstack.miportfolio.Service;

import com.portfoliofullstack.miportfolio.Models.Experiencia;
import com.portfoliofullstack.miportfolio.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired IExperienciaRepository expRepo;
    
    public List<Experiencia> getExperiencia() {
        return expRepo.findAll();
    }
    
    public Experiencia findExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
    public Experiencia addExperiencia(Experiencia experiencia) {
        return expRepo.save(experiencia);
    }
    
    public Experiencia editExperiencia(Experiencia experiencia) {
        return expRepo.save(experiencia);
    }
    
    public void deleteExperiencia(Long id) {
        expRepo.deleteById(id);
    }
}
