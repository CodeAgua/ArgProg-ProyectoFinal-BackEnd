package com.portfolio.ler.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    
    @NotBlank
    private String tituloP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String demoP;
    @NotBlank
    private String repoP;
    @NotBlank
    private String urlimagenP;

    public dtoProyecto() {
    }

    public dtoProyecto(String tituloP, String descripcionP, String demoP, String repoP, String urlimagenP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.demoP = demoP;
        this.repoP = repoP;
        this.urlimagenP = urlimagenP;
    }
}
