package com.portfoliofullstack.miportfolio.security.Service;

import com.portfoliofullstack.miportfolio.security.Models.Rol;
import com.portfoliofullstack.miportfolio.security.Repository.RolRepository;
import com.portfoliofullstack.miportfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired RolRepository rolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepo.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol) {
        rolRepo.save(rol);
    }
}
