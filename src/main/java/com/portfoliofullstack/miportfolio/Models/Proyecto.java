package com.portfoliofullstack.miportfolio.Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyecto implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProyecto;
    
    private String tituloProyecto;
    private String descProyecto;
    private String urlProyecto;
    private String imagenProyecto;

    public Proyecto() {
    }
    
    public Proyecto(Long id, String tituloProyecto, String descProyecto, String urlProyecto, String imgProyecto) {
        this.idProyecto = id;
        this.tituloProyecto = tituloProyecto;
        this.descProyecto = descProyecto;
        this.urlProyecto = urlProyecto;
        this.imagenProyecto = imgProyecto;
    }

}
