package com.portfolio.ler.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String nombre;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 400, message = "Es demasiado corto o demasiado largo.")
    private String img;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String titulo;
    
    @NotBlank
    @Size(min = 1, max = 800, message = "Es demasiado corto o demasiado largo.")
    private String descripcion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String titulo, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
