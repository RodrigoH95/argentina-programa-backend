package com.portfoliofullstack.miportfolio.Service;

import com.portfoliofullstack.miportfolio.Models.Proyecto;
import com.portfoliofullstack.miportfolio.Repository.IProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectosService {

    @Autowired
    IProyectosRepository proyectosRepo;

    public List<Proyecto> getProyectos() {
        return proyectosRepo.findAll();
    }

    public Proyecto findProyecto(Long id) {
        return proyectosRepo.findById(id).orElse(null);
    }

    public Proyecto saveProyecto(Proyecto proyecto) {
        return proyectosRepo.save(proyecto);
    }

    public Proyecto editProyecto(Proyecto proyecto) {
        return proyectosRepo.save(proyecto);
    }

    public void deleteProyecto(Long id) {
        proyectosRepo.deleteById(id);
    }
}
