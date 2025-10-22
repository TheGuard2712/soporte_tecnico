package com.example.soporte.service;

import com.example.soporte.model.Solicitud;
import com.example.soporte.model.EstadoSolicitud;
import java.util.List;

public interface SolicitudService {
    Solicitud crear(Solicitud solicitud, Long clienteId, Long tecnicoId);
    Solicitud actualizar(Long id, Solicitud data, Long clienteId, Long tecnicoId);
    void eliminar(Long id);
    Solicitud obtener(Long id);
    List<Solicitud> listar();
    List<Solicitud> listarPorEstado(EstadoSolicitud estado);
}
