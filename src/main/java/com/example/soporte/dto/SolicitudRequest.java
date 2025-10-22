package com.example.soporte.dto;

import com.example.soporte.model.EstadoSolicitud;
import com.example.soporte.model.Prioridad;

public record SolicitudRequest(
    String titulo,
    String descripcion,
    Prioridad prioridad,
    Long clienteId,
    Long tecnicoId,
    EstadoSolicitud estado
) { }
