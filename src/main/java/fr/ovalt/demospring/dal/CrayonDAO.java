package fr.ovalt.demospring.dal;

import fr.ovalt.demospring.entities.Crayon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrayonDAO {
    private List<Crayon> crayons = List.of(
//            Crayon.builder().type("Stylo").couleur("Bleu").prix(2f).build(),
//            new Crayon(1, "Stylo", "Rouge", 2f),
//            Crayon.builder().type("Criterium").prix(1.5f).build()
    );

    public Crayon get(int id) {
        return crayons.get(id);
    }

    public List<Crayon> getAll() {
        return crayons;
    }
}
