package com.portfolio.ler.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloE;
    private String fechaE;
    private String nombreE;
    
    @Size(min = 1, max = 800, message = "Es demasiado corto o demasiado largo.")
    private String descripcionE;

    public Educacion() {
    }

    public Educacion(String tituloE, String fechaE, String nombreE, String descripcionE) {
        this.tituloE = tituloE;
        this.fechaE = fechaE;
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    
}
