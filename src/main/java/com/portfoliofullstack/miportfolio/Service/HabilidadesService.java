package com.portfoliofullstack.miportfolio.Service;

import com.portfoliofullstack.miportfolio.Models.Habilidades;
import com.portfoliofullstack.miportfolio.Repository.IHabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HabilidadesService {
    @Autowired
    IHabilidadesRepository habRepo;

    public List<Habilidades> getHabilidades() {
        return habRepo.findAll();
    }
    
    public Habilidades findHabilidades(Long id) {
        return habRepo.findById(id).orElse(null);
    }

    public Habilidades addHabilidades(Habilidades habilidad) {
        return habRepo.save(habilidad);
    }

    public Habilidades editHabilidades(Habilidades habilidad) {
        return habRepo.save(habilidad);
    }

    public void deleteHabilidades(Long id) {
        habRepo.deleteById(id);
    }
}
