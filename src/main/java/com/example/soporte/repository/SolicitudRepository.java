package com.example.soporte.repository;

import com.example.soporte.model.Solicitud;
import com.example.soporte.model.EstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByEstado(EstadoSolicitud estado);

    long countByClienteId(Long clienteId);
    long countByTecnicoId(Long tecnicoId);
}
