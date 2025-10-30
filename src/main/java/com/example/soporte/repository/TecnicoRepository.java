package com.example.soporte.repository; 
import com.example.soporte.model.Tecnico; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {}
