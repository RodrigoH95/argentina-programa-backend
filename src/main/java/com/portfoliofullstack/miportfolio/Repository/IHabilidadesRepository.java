package com.portfoliofullstack.miportfolio.Repository;

import com.portfoliofullstack.miportfolio.Models.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadesRepository extends JpaRepository<Habilidades, Long>{

}
