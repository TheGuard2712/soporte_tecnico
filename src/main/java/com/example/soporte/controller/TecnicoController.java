package com.example.soporte.controller;

import com.example.soporte.model.Tecnico;
import com.example.soporte.repository.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// todo: usar responseEntity
@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoRepository repo;

    public TecnicoController(TecnicoRepository repo) {
        this.repo = repo;
    }

  
    @GetMapping
    public List<Tecnico> listar() {
        return repo.findAll();
    }

   
    @GetMapping("/{id}")
    public Tecnico obtener(@PathVariable("id") Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Técnico no encontrado"));
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tecnico crear(@RequestBody Tecnico t) {
        if (t.getNombre() == null || t.getNombre().isBlank()) {
            t.setNombre("SIN NOMBRE");
        }
        return repo.save(t);
    }

   
    @PutMapping("/{id}")
    public Tecnico actualizar(@PathVariable("id") Long id, @RequestBody Tecnico in) {
        Tecnico t = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Técnico no encontrado"));

        if (in.getNombre() != null && !in.getNombre().isBlank()) {
            t.setNombre(in.getNombre());
        }
        if (in.getEspecialidad() != null) {
            t.setEspecialidad(in.getEspecialidad());
        }

        return repo.save(t);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") Long id) {
        if (!repo.existsById(id))
            throw new EntityNotFoundException("Técnico no encontrado");
        repo.deleteById(id);
    }
} 