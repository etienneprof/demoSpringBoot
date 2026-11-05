package fr.ovalt.demospring.services;

import fr.ovalt.demospring.entities.Crayon;
import fr.ovalt.demospring.repositories.CrayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CrayonService {

    private final CrayonRepository crayonRepository;

    @Autowired
    public CrayonService(CrayonRepository crayonRepository) {
        this.crayonRepository = crayonRepository;
    }

    public Crayon get(int id) {
        return crayonRepository.findById(id).orElse(null);
    }

    public List<Crayon> getAll() {
        return crayonRepository.findAll();
    }

    public Crayon save(Crayon crayon) throws Exception {
        if (crayon.getPrix() < 0f) {
            throw new Exception("Le prix du crayon ne peut pas être négatif");
        }
        return crayonRepository.save(crayon);
    }

    public boolean delete(int id) {
        boolean exists = crayonRepository.existsById(id);
        crayonRepository.deleteById(id);
        return exists;
    }
}
