package fr.ovalt.demospring.controllers;

import fr.ovalt.demospring.dto.CrayonDTO;
import fr.ovalt.demospring.entities.Crayon;
import fr.ovalt.demospring.services.CrayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrayonController {

    private final CrayonService crayonService;

    @Autowired
    public CrayonController(CrayonService crayonService) {
        this.crayonService = crayonService;
    }

    @GetMapping("/crayons")
    public ResponseEntity<List<CrayonDTO>> getAll() {
        /* Version itération sur liste
        List<CrayonDTO> result = new ArrayList<>();
        for (var current : crayonService.getAll()) {
            result.add(current.toDTO());
        }

        return  ResponseEntity.ok(result);
        */

        // Version stream
        return ResponseEntity.ok(crayonService.getAll()
                .stream()
                .map(Crayon::toDTO)
                .toList()
        );
    }

    @GetMapping("/crayons/{id}")
    public ResponseEntity<CrayonDTO> getById(@PathVariable("id") int id) {
        var crayon = crayonService.get(id);
        if (crayon == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(crayon.toDTO());
    }
/*
    @PostMapping("/crayons")
    public ResponseEntity<?> add(@RequestBody CrayonDTO crayon) {
        CrayonDTO created = null;
        try {
            created = crayonService.save(crayon);
        } catch (Exception e) {
            ErrorMessage message = new ErrorMessage(e.getMessage());
            return ResponseEntity.badRequest().body(message);
        }
        return ResponseEntity.ok(created);
    }
    */

    @PostMapping("/crayons")
    public ResponseEntity<CrayonDTO> add(@RequestBody CrayonDTO crayon) {
        CrayonDTO created = null;
        try {
            created = crayonService.save(crayon.toEntity()).toDTO();
        } catch (Exception e) {
            created = CrayonDTO.builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(created);
        }
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/crayons/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        boolean result = crayonService.delete(id);

        if (result) return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
