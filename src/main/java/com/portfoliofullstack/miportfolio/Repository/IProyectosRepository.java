package com.portfoliofullstack.miportfolio.Repository;

import com.portfoliofullstack.miportfolio.Models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyecto, Long>{

}
