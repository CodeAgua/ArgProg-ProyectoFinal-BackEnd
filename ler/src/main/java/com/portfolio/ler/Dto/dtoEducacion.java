package com.portfolio.ler.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    @NotBlank
    private String tituloE;
    @NotBlank
    private String fechaE;
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtoEducacion() {
    }

    public dtoEducacion(String tituloE, String fechaE, String nombreE, String descripcionE) {
        this.tituloE = tituloE;
        this.fechaE = fechaE;
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    
}
