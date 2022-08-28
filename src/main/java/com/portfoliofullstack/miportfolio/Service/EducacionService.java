package com.portfoliofullstack.miportfolio.Service;

import com.portfoliofullstack.miportfolio.Models.Educacion;
import com.portfoliofullstack.miportfolio.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository eduRepo;

    public List<Educacion> getEducacion() {
        return eduRepo.findAll();
    }

    public Educacion findEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

    public Educacion addEducacion(Educacion educacion) {
        return eduRepo.save(educacion);
    }

    public Educacion editEducacion(Educacion educacion) {
        return eduRepo.save(educacion);
    }

    public void deleteEducacion(Long id) {
        eduRepo.deleteById(id);
    }

}
