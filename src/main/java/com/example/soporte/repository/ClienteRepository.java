package com.example.soporte.repository; 
import com.example.soporte.model.Cliente; 
import org.springframework.data.jpa.repository.JpaRepository; 

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
