package fr.ovalt.demospring.dto;

import fr.ovalt.demospring.entities.Crayon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrayonDTO {
    private Integer id;
    private String type;
    private String couleur;
    private Float prix;
    private String message;

    public Crayon toEntity() {
        return Crayon.builder()
                .id(id)
                .type(type)
                .couleur(couleur)
                .prix(prix)
                .build();
    }
}
