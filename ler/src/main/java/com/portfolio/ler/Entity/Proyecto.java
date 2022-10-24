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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String tituloP;
    
    @Size(min = 1, max = 600, message = "Es demasiado corto o demasiado largo.")
    private String descripcionP;
    
    private String demoP;
    private String repoP;
    private String urlimagenP;

    public Proyecto() {
    }

    public Proyecto(String tituloP, String descripcionP, String demoP, String repoP, String urlimagenP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.demoP = demoP;
        this.repoP = repoP;
        this.urlimagenP = urlimagenP;
    }
}
