package com.portfoliofullstack.miportfolio.security.Repository;

import com.portfoliofullstack.miportfolio.security.Models.Rol;
import com.portfoliofullstack.miportfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
