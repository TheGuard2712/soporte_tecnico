package com.example.soporte.controller;

import com.example.soporte.repository.ClienteRepository;
import com.example.soporte.model.Cliente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) {
        this.repo = repo;
    }

   
    @GetMapping
    public List<Cliente> listar() {
        return repo.findAll();
    }

    
    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable("id") Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente c) {
        if (c.getNombre() == null || c.getNombre().isBlank()) {
            c.setNombre("SIN NOMBRE");
        }
        return repo.save(c);
    }

   
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable("id") Long id, @RequestBody Cliente in) {
        Cliente c = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        if (in.getNombre() != null && !in.getNombre().isBlank()) c.setNombre(in.getNombre());
        if (in.getEmail() != null) c.setEmail(in.getEmail());
        if (in.getTelefono() != null) c.setTelefono(in.getTelefono());

        return repo.save(c);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") Long id) {
        if (!repo.existsById(id))
            throw new EntityNotFoundException("Cliente no encontrado");
        repo.deleteById(id);
    }
}