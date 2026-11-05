package fr.ovalt.demospring.entities;

import fr.ovalt.demospring.dto.CrayonDTO;
import jakarta.persistence.*;
import lombok.*;

@Data // équivalent à @Getter @Setter @EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity // permet d'indiquer à Spring que la classe doit etre persistee
@Table(name = "crayons") // facultatif, permet de choisir le nom de la table
public class Crayon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String couleur;
    private Float prix;

    public CrayonDTO toDTO() {
        return CrayonDTO.builder()
                .id(id)
                .type(type)
                .couleur(couleur)
                .prix(prix)
                .build();
    }
}
