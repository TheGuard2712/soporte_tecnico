package com.example.soporte.controller;

import com.example.soporte.dto.SolicitudRequest;
import com.example.soporte.model.Solicitud;
import com.example.soporte.model.EstadoSolicitud;
import com.example.soporte.service.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService service;

    public SolicitudController(SolicitudService service) {
        this.service = service;
    }


    @GetMapping
    public List<Solicitud> listar(@RequestParam(name = "estado", required = false) EstadoSolicitud estado) {
    return estado != null ? service.listarPorEstado(estado) : service.listar();
}


    @GetMapping("/{id}")
    public Solicitud obtener(@PathVariable("id") Long id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Solicitud crear(@RequestBody SolicitudRequest req) {
        Solicitud s = new Solicitud();
        s.setTitulo(req.titulo());
        s.setDescripcion(req.descripcion());
        s.setPrioridad(req.prioridad());
        s.setEstado(req.estado());
        return service.crear(s, req.clienteId(), req.tecnicoId());
    }


    @PutMapping("/{id}")
    public Solicitud actualizar(@PathVariable("id") Long id, @RequestBody SolicitudRequest req) {
        Solicitud s = new Solicitud();
        s.setTitulo(req.titulo());
        s.setDescripcion(req.descripcion());
        s.setPrioridad(req.prioridad());
        s.setEstado(req.estado());
        return service.actualizar(id, s, req.clienteId(), req.tecnicoId());
    }

    // ✅ DELETE - eliminar por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") Long id) {
        service.eliminar(id);
    }
}