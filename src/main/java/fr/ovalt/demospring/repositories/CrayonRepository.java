package fr.ovalt.demospring.repositories;

import fr.ovalt.demospring.entities.Crayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrayonRepository extends JpaRepository<Crayon, Integer> {
}
