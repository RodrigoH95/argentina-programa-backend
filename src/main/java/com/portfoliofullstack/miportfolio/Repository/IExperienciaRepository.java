package com.portfoliofullstack.miportfolio.Repository;

import com.portfoliofullstack.miportfolio.Models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    
}
