package com.example.soporte.service;

import com.example.soporte.model.*;
import com.example.soporte.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class SolicitudServiceImpl implements SolicitudService {
    private final SolicitudRepository solicitudes;
    private final ClienteRepository clientes;
    private final TecnicoRepository tecnicos;

    public SolicitudServiceImpl(SolicitudRepository s, ClienteRepository c, TecnicoRepository t) {
        this.solicitudes = s; this.clientes = c; this.tecnicos = t;
    }

    @Override
    public Solicitud crear(Solicitud s, Long clienteId, Long tecnicoId) {
        if (s.getTitulo()==null || s.getTitulo().isBlank()) throw new IllegalArgumentException("El título es obligatorio");
        if (clienteId==null) throw new IllegalArgumentException("clienteId es obligatorio");

        Cliente c = clientes.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        s.setCliente(c);

        if (tecnicoId != null) {
            Tecnico t = tecnicos.findById(tecnicoId).orElseThrow(() -> new EntityNotFoundException("Técnico no encontrado"));
            s.setTecnico(t);
        } else {
            s.setTecnico(null);
        }

        if (s.getPrioridad()==null) s.setPrioridad(Prioridad.MEDIA);
        if (s.getEstado()==null) s.setEstado(EstadoSolicitud.ABIERTA);
        return solicitudes.save(s);
    }

    @Override
    public Solicitud actualizar(Long id, Solicitud data, Long clienteId, Long tecnicoId) {
        Solicitud s = obtener(id);
        if (data.getTitulo()!=null && !data.getTitulo().isBlank()) s.setTitulo(data.getTitulo());
        if (data.getDescripcion()!=null) s.setDescripcion(data.getDescripcion());
        if (data.getPrioridad()!=null) s.setPrioridad(data.getPrioridad());
        if (data.getEstado()!=null) s.setEstado(data.getEstado());

        if (clienteId != null) {
            Cliente c = clientes.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
            s.setCliente(c);
        }
        if (tecnicoId != null) {
            Tecnico t = tecnicos.findById(tecnicoId).orElseThrow(() -> new EntityNotFoundException("Técnico no encontrado"));
            s.setTecnico(t);
        }
        return s;
    }

    @Override public void eliminar(Long id) {
        if (!solicitudes.existsById(id)) throw new EntityNotFoundException("Solicitud no encontrada");
        solicitudes.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public Solicitud obtener(Long id) {
        return solicitudes.findById(id).orElseThrow(() -> new EntityNotFoundException("Solicitud no encontrada"));
    }

    @Override @Transactional(readOnly = true)
    public List<Solicitud> listar() { return solicitudes.findAll(); }

    @Override @Transactional(readOnly = true)
    public List<Solicitud> listarPorEstado(EstadoSolicitud estado) { return solicitudes.findByEstado(estado); }
}
