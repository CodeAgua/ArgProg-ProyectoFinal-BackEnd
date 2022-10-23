package com.portfolio.ler.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    @NotBlank
    private String tituloE;
    @NotBlank
    private String fechaE;
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String tituloE, String fechaE, String nombreE, String descripcionE) {
        this.tituloE = tituloE;
        this.fechaE = fechaE;
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
}
