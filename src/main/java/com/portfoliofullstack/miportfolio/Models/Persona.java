package com.portfoliofullstack.miportfolio.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Entrada no válida, debe ser entre 1 y 50 caracteres")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "Entrada no válida, debe ser entre 1 y 50 caracteres")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Entrada no válida, debe ser entre 1 y 50 caracteres")
    private String titulo;
    
    @Size(max = 500, message = "La descripción no puede ser mayor a 500 caracteres")
    private String descripcion;
    
    @Size(min = 1, max = 200, message = "Entrada no válida, debe ser entre 1 y 200 caracteres")
    private String img;
    
    @Size(min = 1, max = 200, message = "Entrada no válida, debe ser entre 1 y 200 caracteres")
    private String imgBanner;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> listaEducacion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia> listaExperiencia;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idHab")
    private List<Habilidades> listaHabilidades;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProyecto")
    private List<Proyecto> listaProyectos;

    public Persona() {}
    
    public Persona(Long id, String nombre, String apellido, String titulo, String descripcion, String img, String imgBanner) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
        this.imgBanner = imgBanner;
    }
    
    
}
